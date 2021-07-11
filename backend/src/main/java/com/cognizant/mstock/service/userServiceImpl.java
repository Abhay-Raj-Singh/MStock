package com.cognizant.mstock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.mstock.dao.UserDao;
import com.cognizant.mstock.entity.Users;


@Service
public class userServiceImpl implements userService{
	
	
	

		@Autowired
		private UserDao userDao;

		public Users validateUserLogin(String user_email, String user_pwd) {
			Users validUser = userDao.find(user_email);
			System.out.println(validUser);
			if (validUser != null) {
				if (validUser.getUser_pwd().equals(user_pwd)) {
					return validUser;
				}
			}
			return null;
		}
		
		
	}


