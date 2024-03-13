package com.blogservice.blog.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogservice.blog.entities.UserModel;
import com.blogservice.blog.repo.UserModelRepo;

@SpringBootTest
public class LoginRepoTests {
	
	@Autowired
	UserModelRepo userRepo  ;
	
	@Test
	public void testFindMethod() {
		UserModel user  = UserModel.builder()
				.firstName("vivek")
				.lastName("vivek")
				.email("test")
				.build();
		userRepo.save(user);
		List<UserModel> userModels =userRepo.findAll();
		System.out.println("test ==> " + userModels);
	}
	
	@Test
	public void findAll() {
		
		
	}
}
