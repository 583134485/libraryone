

package com.guo.ssm.dto;

import java.io.Serializable;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月17日 下午3:19:00
* @version 1.0 
* @parameter  
* @Description: TODO(零时 3d销量 展示DTO) 
* @since  
* @return  */
public class GoodSale3DDto implements Serializable{
	
	 public String type;
	//strign 主要是为了避免 读取excel （excel 所有数据都转化为 string）的麻烦
	 public String sale;
	 
	 public String month;
	 
 public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
@Override
	public String toString() {
		return "GoodSale3DDto [type=" + type + ", sale=" + sale + ", month=" + month + "]";
	}

}
