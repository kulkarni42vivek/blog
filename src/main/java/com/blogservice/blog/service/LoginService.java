package com.blogservice.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.blogservice.blog.model.ResponseMessage;
import com.blogservice.blog.repo.UserModelRepo;
import com.blogservice.blog.util.Constants;
import com.blogservice.blog.entities.UserModel;

@Service
public class LoginService {
	
	
	@Autowired
	UserModelRepo userRepo;

	public ResponseMessage registerUser(UserModel userDto) {
		try {
			Optional<UserModel> existingUser = userRepo.findById(userDto.getUserId());
	        if (existingUser.isPresent()) {
	            return ResponseMessage.builder()
	            		.errorCode(Constants.ErrorCodes.USER_EXIST)
	            		.errorMessage("user already exists")
	            		.build();
	        }

	        userRepo.save(userDto);
		}
		catch(Exception e) {
			return ResponseMessage.builder()
					.errorCode(Constants.ErrorCodes.TRANSACTION_FAILED)
					.errorMessage("transaction failed")
					.build();
		}
		return ResponseMessage.builder()
				.errorCode(Constants.ErrorCodes.TRANSACTION_SUCCESS)
				.errorMessage("transaction success")
				.build();
	}

	public UserModel getUserInfo(UserModel userDto) {
		Optional<UserModel> user = userRepo.findById(userDto.getUserId());
		if(user.isEmpty()) {
			return null;
		}
		return user.get();
	}
	
}
