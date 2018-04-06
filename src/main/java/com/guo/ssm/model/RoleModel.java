

package com.guo.ssm.model;

import java.io.Serializable;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午1:29:01
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
public class RoleModel implements Serializable {
	public Long roleid;
	public String role;
	public String description;
	
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "RoleModel [roleid=" + roleid + ", role=" + role + ", description=" + description + "]";
	}
	

}
