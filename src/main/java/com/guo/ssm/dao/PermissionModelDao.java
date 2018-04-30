

package com.guo.ssm.dao;

import com.guo.ssm.model.PermissionModel;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午2:08:06
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
public interface PermissionModelDao {

	void createPermission(PermissionModel permissionModel);
	
	void deletePermission(Long permissionid);
}
