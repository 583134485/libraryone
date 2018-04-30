
package com.guo.ssm.shiro.service;

import javax.management.relation.Role;

import com.guo.ssm.model.RoleModel;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午6:56:50
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
public interface RoleService {
	
	void createRole(RoleModel role);
	
	void addRolePermission(Long roleid,Long permissionid);
	
	

}
