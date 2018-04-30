package com.guo.ssm.model;

public class ItemsCustom {
	private String name;
	@Override
	public String toString() {
		return "ItemsCustom [name=" + name + ", price=" + price + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	private  String price;
	
		

}
