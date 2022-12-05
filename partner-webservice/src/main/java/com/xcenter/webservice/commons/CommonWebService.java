package com.xcenter.webservice.commons;

import com.xcenter.models.UserInfo;
import com.xcenter.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonWebService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/findUserInfo/{userName}", method = RequestMethod.GET)
    public UserInfo findUserInfo(@PathVariable String userName){
        return userInfoRepository.findByUsername(userName).get();
    }
}
