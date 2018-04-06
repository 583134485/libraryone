package com.guo.ssm.dto;

import java.util.List;

public class JsonDemoChildrenDto {
	public String discretion;
	   public List<String> value;
	   public String id;
	   public String name;
	   
	   public JsonDemoChildrenDto(){	   
	   }
	
	public String getDiscretion() {
		return discretion;
	}
	public void setDiscretion(String discretion) {
		this.discretion = discretion;
	}
	public List<String> getValue() {
		return value;
	}
	public void setValue(List<String> value) {
		this.value = value;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public JsonDemoChildrenDto(String discretion, List<String> value, String id, String name) {
		super();
		this.discretion = discretion;
		this.value = value;
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "JsonDemoChildrenDto [discretion=" + discretion + ", value=" + value + ", id=" + id + ", name=" + name
				+ "]";
	}

   
}
