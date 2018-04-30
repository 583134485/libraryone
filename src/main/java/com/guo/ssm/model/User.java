package com.guo.ssm.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	
	
	private long   userid;
	@NotEmpty
	@Size(min=3, max=10)
	private String userpassword;
	@NotEmpty
	@Size(min=3, max=30)
	private String username;
	@NotEmpty
	@Size(min=3, max=10)
	private String userclass;
	
	
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
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
	public String getUserclass() {
		return userclass;
	}
	public void setUserclass(String userclass) {
		this.userclass = userclass;
	}
	@Override
	public String toString() {
		return "User [useid=" + userid
				+ ", userpassword=" + userpassword 
				+ ", username=" + username 
				+ ", userclass=" + userclass +
				 "]";
	}
	
	
	
	

}
