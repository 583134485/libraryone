

package com.guo.ssm.shiro.service.impl;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guo.ssm.dao.UserModelDao;
import com.guo.ssm.model.UserModel;
import com.guo.ssm.shiro.service.UserModelService;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午7:01:39
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
@Service
public class UserModelServiceImpl implements UserModelService {
 Logger log=Logger.getLogger(getClass());
	@Autowired
	UserModelDao usermodeldao;
	
	@Override
	public void createUser(UserModel userModel) {
	usermodeldao.createUser(userModel);
		
	}

	@Override
	public void addUserRole(Long userid, Long roleid) {
		usermodeldao.addUserRole(userid, roleid);
		
	}

	@Override
	public Set<String> findRoles(String username) {
		Set<String> roles=usermodeldao.findRoles(username);
		log.info("findroles:"+roles);
		return roles;
	}

	@Override
	public Set<String> findPermissions(String username) {
		Set<String> permissions=usermodeldao.findPermissions(username);
		log.info("findpermission:"+permissions);
		return permissions;
	}

	@Override
	public UserModel findByUsername(String username) {
		log.info("search-user:"+username);
		UserModel user=usermodeldao.FindByName(username);
		return user;
	}

	@Override
	public void addUser(String username, String password) {
		UserModel userModel=new UserModel();
		userModel.setSalt("testsalt");
		userModel.setUsername(username);
		userModel.setUserpassword(password);
		usermodeldao.createUser(userModel);
		
	}

	
}
