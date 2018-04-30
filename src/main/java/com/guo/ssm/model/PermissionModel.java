
package com.guo.ssm.model;
/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午1:29:44
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */

import java.io.Serializable;

public class PermissionModel implements Serializable {
	
	public Long permissionid;
	public String permission;
	public String description;
	
	public Long getPermissionid() {
		return permissionid;
	}
	public void setPermissionid(Long permissionid) {
		this.permissionid = permissionid;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "PermissionModel [permissionid=" + permissionid + ", permission=" + permission + ", description="
				+ description + "]";
	}

	
}
