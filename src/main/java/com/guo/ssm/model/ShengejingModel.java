package com.guo.ssm.model;

import java.io.Serializable;
import java.sql.Timestamp;


public class ShengejingModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    //商品标题
	public String name;
	
	//商品 ID
	public String id;
	//热搜词
	 public String  hotword;
	 //pc流量
	 public String pc;
	 //手机流量
	 public String app;
	 //店铺名称
	 public String shop;
	 //商家编码
	 public String code;
	 //行业类目
	 public String type;
	 //上架时间
	 public Timestamp  uptime;
	  //记录时间
	 public Timestamp recordtime;
	 @Override
		public String toString() {
			return "ShengejingModel [name=" + name + ", id=" + id + ", hotword=" + hotword + ", pc=" + pc + ", app=" + app
					+ ", shop=" + shop + ", code=" + code + ", type=" + type + ", uptime=" + uptime + ", recordtime="
					+ recordtime + "]";
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getHotword() {
			return hotword;
		}
		public void setHotword(String hotword) {
			this.hotword = hotword;
		}
		public String getPc() {
			return pc;
		}
		public void setPc(String pc) {
			this.pc = pc;
		}
		public String getApp() {
			return app;
		}
		public void setApp(String app) {
			this.app = app;
		}
		public String getShop() {
			return shop;
		}
		public void setShop(String shop) {
			this.shop = shop;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Timestamp getUptime() {
			return uptime;
		}
		public void setUptime(Timestamp uptime) {
			this.uptime = uptime;
		}
		public Timestamp getRecordtime() {
			return recordtime;
		}
		public void setRecordtime(Timestamp recordtime) {
			this.recordtime = recordtime;
		}
	
	
}
