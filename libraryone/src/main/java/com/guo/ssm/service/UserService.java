package com.guo.ssm.service;

import java.util.List;

import com.guo.ssm.model.User;

public interface UserService {
	List <User> fingAllUser();
	
	void updateUser(User user);
	
	void addUser(User user);
	
	void deleteUserById(long userid);
	
	 User findUserById(long userid);
	 
	
	
	
	
	

}
