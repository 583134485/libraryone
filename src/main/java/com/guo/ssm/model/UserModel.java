

package com.guo.ssm.model;

import java.io.Serializable;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午1:27:47
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
public class UserModel  implements Serializable{
	
	public Long userid;
	public String userpassword;
	public String username;
	public String salt;
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "UserModel [userid=" + userid + ", userpassword=" + userpassword + ", username=" + username + ", salt="
				+ salt + "]";
	}
	
	

}
