
package com.guo.ssm.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guo.ssm.dao.PermissionModelDao;
import com.guo.ssm.model.PermissionModel;
import com.guo.ssm.shiro.service.PermissionService;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午7:08:11
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	PermissionModelDao permissionmodeldao;
	
	@Override
	public void createPermission(PermissionModel permissionModel) {
		permissionmodeldao.createPermission(permissionModel);
		
	}

}
