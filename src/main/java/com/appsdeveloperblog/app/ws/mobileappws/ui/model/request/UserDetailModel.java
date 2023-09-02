package com.appsdeveloperblog.app.ws.mobileappws.ui.model.request;

import jakarta.validation.constraints.*;

public class UserDetailModel {

    @NotNull (message="firstname can't be null")
    private String firstname;
    @NotNull (message="lastname can't be null")
    private String lastname;
    @NotNull (message="email can't be null")
    private String email;
    @NotNull (message="userId can't be null")
    @Size(min=8,max=16,message="password must be >=6 & <-16")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
