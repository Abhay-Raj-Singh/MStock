package com.cognizant.mstock.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.mstock.entity.Users;


@Repository
public interface UserDao extends JpaRepository<Users, Serializable> {
	
	
	// List<User> findAll();
	@Query(value ="select * from users where user_email=?", nativeQuery = true)
	Users find(String user_email);
	
	

}
