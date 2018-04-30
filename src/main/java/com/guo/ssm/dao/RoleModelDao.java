

package com.guo.ssm.dao;

import org.apache.ibatis.annotations.Param;

import com.guo.ssm.model.RoleModel;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午1:54:53
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
public interface RoleModelDao {

	void createRole(RoleModel role);
	
	void updateRole(RoleModel role);
	
	//单纯删除role
	void deleteByModel(RoleModel role);
	
	//role permission relation
	void addRolePermission(@Param("roleid")Long roleid,@Param("permissionid")Long permissionid);
	
	void deleteRolePermission(@Param("roleid")Long roleid,@Param("permissionid")Long permissionid );
	
}
