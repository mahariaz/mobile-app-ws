package com.appsdeveloperblog.app.ws.mobileappws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class UtilsClass {
    public String generateUserId(){
        return UUID.randomUUID().toString();
    }
}
