package com.appsdeveloperblog.app.ws.mobileappws.ui.controller;

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.appsdeveloperblog.app.ws.mobileappws.repository.UserRepository;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.request.UpdateUserDetailModel;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.request.UserDetailModel;
import com.appsdeveloperblog.app.ws.mobileappws.ui.model.response.UserRest;


import com.appsdeveloperblog.app.ws.mobileappws.userservice.UserServices;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/users") //http://localhost:8080/users
public class UserController {

   

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServices userService;

    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        //users = userStorage.getUsers();
      
        Optional<UserRest> user = userRepository.findById(userId);
        if (user.isPresent()) {
            // getting the wole map with that particular userId(key)
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            // return empty response
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailModel userDetails) {
        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}")
    public UserRest updateUser(@Valid @RequestBody UpdateUserDetailModel userDetails, @PathVariable String userId) {
        Optional<UserRest> user = userRepository.findById(userId);
        if (user.isPresent()){
            UserRest standardUserDetails = user.get();
            standardUserDetails.setFirstname(userDetails.getFirstname());
            standardUserDetails.setLastname(userDetails.getLastname());
            userRepository.save(standardUserDetails); // Save the updated user details
            return standardUserDetails;

        }else{
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }


    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userRepository.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
}
