

package com.guo.ssm.model;

import java.io.Serializable;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午1:30:23
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
public class UserRoleModel implements Serializable {
	
	public Long userid;
	public Long roleid;
	
	@Override
	public String toString() {
		return "UserRoleModel [userid=" + userid + ", roleid=" + roleid + "]";
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}


}
