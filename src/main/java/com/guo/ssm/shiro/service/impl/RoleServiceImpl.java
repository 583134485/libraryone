

package com.guo.ssm.shiro.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guo.ssm.dao.RoleModelDao;
import com.guo.ssm.model.RoleModel;
import com.guo.ssm.shiro.service.RoleService;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午7:05:37
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
@Service
public class RoleServiceImpl implements RoleService {

	Logger log=Logger.getLogger(getClass());
	@Autowired
	RoleModelDao rolemodeldao;
	@Override
	public void createRole(RoleModel role) {
		rolemodeldao.createRole(role);
		
	}

	@Override
	public void addRolePermission(Long roleid, Long permissionid) {
		rolemodeldao.addRolePermission(roleid, permissionid);
		
	}

}
