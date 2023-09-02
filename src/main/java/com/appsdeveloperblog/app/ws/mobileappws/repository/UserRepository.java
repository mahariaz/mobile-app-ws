package com.appsdeveloperblog.app.ws.mobileappws.repository;

import com.appsdeveloperblog.app.ws.mobileappws.ui.model.response.UserRest;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface UserRepository extends CrudRepository<UserRest,String> {
}
