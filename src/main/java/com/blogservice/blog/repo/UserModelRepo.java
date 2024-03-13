package com.blogservice.blog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blogservice.blog.entities.UserModel;

import jakarta.transaction.Transactional;

@Repository
public interface UserModelRepo extends JpaRepository<UserModel, Long>{
	
	List<UserModel> findByFirstNameContaining(String userId);
	
	List<UserModel>  findByMobileNotNull();
	
	@Query("select u from UserModel u where u.mobile = ?1 and u.email = ?2")
	List<UserModel> getEmailAndMobile(String mobile , String email);
	
	@Transactional
	@Modifying
	@Query(value ="update user_mstr set mobile  =: mobileN where userId =: userID",nativeQuery = true )
	List<UserModel> UpdateUsingNativeQuery(@Param("mobileN")String mobile,  @Param("userID")long userId);
	
}
