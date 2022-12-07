import React, {useEffect} from 'react';
import {CalcWidthBasedOnStringLengthProps} from "./CalcWidthBasedOnStringLengthProps";
import {withTranslation} from "react-i18next";
import {useDispatch} from "react-redux";

const CalcWidthBasedOnStringLength = (props: CalcWidthBasedOnStringLengthProps) => {

    const {t} = props;
    const dispatch = useDispatch();

    useEffect(() => {
        calcWidthBasedOnStringLength(listHeaderTitle, listHeaderTitle, [], '', '');
    })

    const listHeaderTitle = [
        {
            columnCode: 'userName',
            columnName: 'Username'
        },
        {
            columnCode: 'password',
            columnName: 'Password'
        }
    ]

    const calcWidthBasedOnStringLength = (listData: any, listHeaderTitle?: any, keyCode?: any, tableProps?: any, actions?: any) => {

        dispatch(actions.resetTableProps());

        let listTranslatedHeader: any[] = [];

        if (_.isNil(listHeaderTitle) && _.isEmpty(listHeaderTitle)){

            listHeaderTitle.forEach((column: any) => {

                const widthOfTranslatedHeaderColumn = calcLengthData(column.columnCode); // 7 is number pixel of English

                const result = {
                    columnCode: column.columnCode,
                    width: widthOfTranslatedHeaderColumn,
                    defaultWidth: column.width
                }
                listTranslatedHeader.push(result);

                dispatch(actions.updateTableProps({
                    ...tableProps,
                    overrideColumnWidth: {
                        [column.columnCode]: widthOfTranslatedHeaderColumn
                    }
                }));

            })

        }

        if(keyCode.length > 0 && listData.length > 0){
            listData.forEach((data: any) => {
                keyCode.forEach((key: string) => {
                    const lengthOfData = calcLengthData(data[key].toString());
                    const currentWidthData = tableProps.overrideColumnWidth[key];
                    if(lengthOfData){
                        listTranslatedHeader.forEach((result: any) => {
                            const defaultWidth = result.defaultWidth;
                            dispatch(actions.updateTableProps({
                                ...tableProps,
                                overrideColumnWidth: {
                                    [key]: lengthOfData > currentWidthData && lengthOfData < defaultWidth ? lengthOfData : (currentWidthData < defaultWidth ? currentWidthData : defaultWidth)
                                }
                            }));
                        })
                    }
                })
            })
        }

    }

    const calcLengthData = (data: string) => {
        return data.length * 7;
    }

    return(
        <>

        </>
    )

}

export default withTranslation('TRANSLATION_NAMESPACE')(CalcWidthBasedOnStringLength);