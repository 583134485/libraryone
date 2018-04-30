

package com.guo.ssm.dao;
/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午1:49:22
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */


import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.guo.ssm.model.UserModel;

public interface UserModelDao {
	
	
	//单插入用户信息
	void createUser(UserModel user);
	// find by name
	UserModel FindByName(String username);
		
	//find by id
	UserModel FindById(Long id);
	//
	void deteteUserByName(String username);
	
	//user role relation 两个参数要 写参数名param
	void addUserRole(@Param("userid")Long userid ,@Param("roleid")Long roleid);
	//delete role user
	void deleteUserRole(@Param("userid")Long userid ,@Param("roleid")Long roleid);
	
	//
	Set<String> findRoles(String username);
	
    //
	Set<String> findPermissions(String username);
	

	
}
