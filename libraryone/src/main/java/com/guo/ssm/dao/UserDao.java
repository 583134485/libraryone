package com.guo.ssm.dao;

import java.util.List;

import com.guo.ssm.model.User;

public interface UserDao {
	
     List <User> findAllUser();
     
     
	void addUser(User user);
	
	void  updateUser(User user); 
	
	void deleteUser(long userid);
	
	User findUserById(long userid);


	
	
	

}
