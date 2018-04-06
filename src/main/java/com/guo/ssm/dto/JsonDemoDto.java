 package com.guo.ssm.dto;

import java.util.List;

public class JsonDemoDto  {
	
    public List<JsonDemoChildrenDto> children;
    public String discretion;
    public String id;
    public String name;
    public List<String> value;
    public JsonDemoDto(List<JsonDemoChildrenDto> children, String discretion, String id, String name,
			List<String> value) {
		super();
		this.children = children;
		this.discretion = discretion;
		this.id = id;
		this.name = name;
		this.value = value;
	}
    
	public JsonDemoDto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JsonDemoDto [children=" + children + ", discretion=" + discretion + ", id=" + id + ", name=" + name
				+ ", value=" + value + "]";
	}
	public List<JsonDemoChildrenDto> getChildren() {
		return children;
	}
	//add添加方法暂时解决树形数据
	public void addChildren(JsonDemoChildrenDto childrenDto){
		this.children.add(childrenDto);
	}
	public void setChildren(List<JsonDemoChildrenDto> children) {
		this.children = children;
	}
	public String getDiscretion() {
		return discretion;
	}
	public void setDiscretion(String discretion) {
		this.discretion = discretion;
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
	public List<String> getValue() {
		return value;
	}
	public void setValue(List<String> value) {
		this.value = value;
	}
	
	
}
