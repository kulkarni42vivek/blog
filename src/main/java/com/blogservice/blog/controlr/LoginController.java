package com.blogservice.blog.controlr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogservice.blog.entities.UserModel;
import com.blogservice.blog.model.ResponseMessage;
import com.blogservice.blog.service.LoginService;
import com.blogservice.blog.util.Constants;

@RestController
public class LoginController {
	
	@Autowired
    private LoginService loginService;
	

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserModel userDto) {
    	ResponseMessage  res = loginService.registerUser(userDto);
    	if(res.getErrorCode() == Constants.ErrorCodes.USER_EXIST) {
    		return ResponseEntity.status(HttpStatus.CONFLICT).body("USER ALREADY EXISTS ");
    	}
    	else if(res.getErrorCode() == Constants.ErrorCodes.TRANSACTION_SUCCESS) {
    		 return ResponseEntity.ok("User registered successfully");
    	}
    	else {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error");
    	}
    }
    
    
    @PostMapping("/getUserInfo")
    public ResponseEntity<UserModel> getUserInfo(@RequestBody UserModel userDto) {
    	UserModel  res = loginService.getUserInfo(userDto);
    	return ResponseEntity.ok(res);
    }
}
