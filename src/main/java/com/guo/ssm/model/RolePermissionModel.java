

package com.guo.ssm.model;

import java.io.Serializable;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午1:31:37
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
public class RolePermissionModel implements Serializable {

	
	public Long roleid;
	 public Long permissionid;
	 
	 @Override
	public String toString() {
		return "RolePermissionModel [roleid=" + roleid + ", permissionid=" + permissionid + "]";
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public Long getPermissionid() {
		return permissionid;
	}
	public void setPermissionid(Long permissionid) {
		this.permissionid = permissionid;
	}

	 
}
