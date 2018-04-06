package com.guo.ssm.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;


public class ShengejingDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//店铺
	 public String shop;
	//某天
	 //有时候也粗暴表示一段时间
		 public String recordtime;
		//数据这里用map嵌套(type>pc/app)
		 //所有type 的所有app/pc 流量 热搜词
		 //其实放到一个map里还是绕远路了，不如降低维度，操作方便易读懂，算了写都写了
		public HashMap<String,HashMap<String,String>> typedata;
		
		//多个时间list数据，表示时间跨度
		//但本想表达，一天一个数据，放到这个dto类里不妥
		//这个dto设计的初衷就比较模糊，不要随便添加变量
		//以下变量废了暂时
		public List<String> listrecordtime;
	@Override
	public String toString() {
		return "ShengejingDto [shop=" + shop + ", recordtime=" + recordtime + ", typedata=" + typedata
				+ ", listrecordtime=" + listrecordtime + "]";
	}

	public String getShop() {
		return shop;
	}

	public void setShop(String shop) {
		this.shop = shop;
	}

	public String getRecordtime() {
		return recordtime;
	}

	public void setRecordtime(String recordtime) {
		this.recordtime = recordtime;
	}

	public HashMap<String, HashMap<String, String>> getTypedata() {
		return typedata;
	}

	public void setTypedata(HashMap<String, HashMap<String, String>> typedata) {
		this.typedata = typedata;
	}

	public List<String> getListrecordtime() {
		return listrecordtime;
	}

	public void setListrecordtime(List<String> listrecordtime) {
		this.listrecordtime = listrecordtime;
	}

	


  
	
}
