package com.xcenter.services.impl;

import com.xcenter.models.UserInfo;
import com.xcenter.repository.UserInfoRepository;
import com.xcenter.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoImplement implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo getUserInfoByUsername(String username) {
        return userInfoRepository.getUserInfoByUsername(username);
    }
}
