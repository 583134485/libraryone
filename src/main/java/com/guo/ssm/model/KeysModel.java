package com.guo.ssm.model;

public class KeysModel {

	/*public int id;
	public String name;
	public String url;
	public String type;
	public int state;*/
	private int id;
	private String name;
	private String url;
	private String type;
	private int state;
	//配合mybatis查询 加默认构造函数通过
	public KeysModel(){}
	public KeysModel(int id, String name, String url, String type, int state) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.type = type;
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "KeysModel [id=" + id + ", name=" + name + ", url=" + url + ", type=" + type + ", state=" + state + "]";
	}

}
