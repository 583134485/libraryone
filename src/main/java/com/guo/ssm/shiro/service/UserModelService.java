

package com.guo.ssm.shiro.service;

import java.util.Set;

import com.guo.ssm.model.UserModel;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午6:48:48
* @version 1.0 
* @parameter  
* @Description: TODO(不同包还是不要有同名类的好) 
* @since  
* @return  */
public interface UserModelService {

	/**  
	* @Title: createUser  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @param @param userModel    参数  
	* @return void    返回类型  
	* @throws  
	*/  
	void createUser(UserModel userModel);
	
	//暂是用于注册的 add user
	void addUser(String username,String password);
	
	void addUserRole(Long userid,Long roleid);
	
	Set<String> findRoles(String username);
	
	Set<String> findPermissions(String username);

	UserModel findByUsername(String username);
  
	
}
