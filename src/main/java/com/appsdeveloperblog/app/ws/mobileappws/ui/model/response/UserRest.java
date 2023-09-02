package com.appsdeveloperblog.app.ws.mobileappws.ui.model.response;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Data;
@DynamoDBTable(tableName = "users")
@Data
public class UserRest {
    @DynamoDBAttribute(attributeName = "firstname")
    private String firstname;
    @DynamoDBAttribute(attributeName = "lastname")
    private String lastname;
    @DynamoDBAttribute(attributeName = "email")
    private String email;
    @DynamoDBHashKey(attributeName = "id")
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



}
