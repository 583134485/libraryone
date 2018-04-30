package com.guo.ssm.model;

import java.io.Serializable;

public class HotGoodsModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//关于data，首先是否一定要使用data类型，如果不比我就用string了
		public String data;
		//流量
		public int flow;
		//支付
		public int payment;
		//加购
		private int plus;
		//金额
		public int money;
		//转化
		public String  conversion;
		
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getFlow() {
		return flow;
	}
	public void setFlow(int flow) {
		this.flow = flow;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getPlus() {
		return plus;
	}
	public void setPlus(int plus) {
		this.plus = plus;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getConversion() {
		return conversion;
	}
	public void setConversion(String conversion) {
		this.conversion = conversion;
	}
	@Override
	public String toString() {
		return "HotGoodsModel [data=" + data + ", flow=" + flow + ", payment=" + payment + ", plus=" + plus + ", money="
				+ money + ", conversion=" + conversion + "]";
	}
	
	
	
	
	
	
	

}
