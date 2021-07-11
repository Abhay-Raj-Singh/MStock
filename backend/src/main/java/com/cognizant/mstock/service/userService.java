package com.cognizant.mstock.service;

import com.cognizant.mstock.entity.Users;

public interface userService {
	
	Users validateUserLogin(String user_email, String user_pwd);
	

}
