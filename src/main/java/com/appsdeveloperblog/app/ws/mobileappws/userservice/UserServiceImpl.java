package com.appsdeveloperblog.app.ws.mobileappws.userservice;

import java.util.HashMap;
import java.util.Map;


import com.appsdeveloperblog.app.ws.mobileappws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.mobileappws.shared.UtilsClass;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.request.UserDetailModel;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.response.UserRest;

@Service
public class UserServiceImpl implements UserServices {

 

    @Autowired
    private UserRepository userRepository;
    UtilsClass utils;
    public UserServiceImpl(){


    }
    // constructor based Dependency Injection
    @Autowired
    public UserServiceImpl(UtilsClass utils){
        this.utils=utils;
    }
    @Override
    public UserRest createUser(UserDetailModel userDetails) {
  
        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstname(userDetails.getFirstname());
        returnValue.setLastname(userDetails.getLastname());
        // universal identifier to create random string
        String userId= utils.generateUserId();
        returnValue.setUserId(userId);
        userRepository.save(returnValue);
        return returnValue;

    }

}
