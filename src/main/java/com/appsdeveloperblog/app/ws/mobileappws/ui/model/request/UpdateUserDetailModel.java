package com.appsdeveloperblog.app.ws.mobileappws.ui.model.request;

import jakarta.validation.constraints.NotNull;

public class UpdateUserDetailModel {
    @NotNull(message="firstname can't be null")
    private String firstname;
    @NotNull (message="lastname can't be null")
    private String lastname;

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
}
