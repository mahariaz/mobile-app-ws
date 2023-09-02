package com.appsdeveloperblog.app.ws.mobileappws.userservice;

import com.appsdeveloperblog.app.ws.mobileappws.ui.model.request.UserDetailModel;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.response.UserRest;

public interface UserServices {
    UserRest createUser(UserDetailModel userDetails);

}
