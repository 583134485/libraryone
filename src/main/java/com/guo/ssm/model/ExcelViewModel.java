package com.guo.ssm.model;



import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ExcelViewModel {
	@Id
	public String id;
	
	public String filename;
	
	public List data;
	//流量
	public List flow;
	//支付
	public List payment;
	//加购
	public  List plus;
	//金额
	public List money;
	//转化
	public List  conversion;
	//单价
	public List price;
	public String getfilename() {
		return filename;
	}
	public void setfilename(String filename) {
		this.filename=filename;
	}
	
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public List getFlow() {
		return flow;
	}
	public void setFlow(List flow) {
		this.flow = flow;
	}
	public List getPayment() {
		return payment;
	}
	public void setPayment(List payment) {
		this.payment = payment;
	}
	public List getPlus() {
		return plus;
	}
	public void setPlus(List plus) {
		this.plus = plus;
	}
	public List getMoney() {
		return money;
	}
	public void setMoney(List money) {
		this.money = money;
	}
	public List getConversion() {
		return conversion;
	}
	public void setConversion(List conversion) {
		this.conversion = conversion;
	}
	public List getPrice() {
		return price;
	}
	public void setPrice(List price) {
		this.price = price;
	}



}
