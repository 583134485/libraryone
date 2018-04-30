package com.guo.ssm.dto;

import java.sql.Date;
import java.sql.Timestamp;





public class TaobaoDto {
/*	public TaobaoDto() {
	}*/
	

	public String shop;
	public String URL;
	public String ID;
	public String totalSale;
	public String tPrice;
	public String name;
	public String pic;
	public String brand;
	public String material;
	public String season;
	public String color;
	public String sex;
	public String fabric;
	public String style;
	public String paint;
	public String huohao;
	public String qudao;
	public String oPrice;
	public String sizeColor;
	public String SKU;
	public String stock;
	public Timestamp recordTime;
	public TaobaoDto(String shop, String uRL, String iD, String totalSale, String tPrice, String name, String pic,
			String brand, String material, String season, String color, String sex, String fabric, String style,
			String paint, String huohao, String qudao, String oPrice, String sizeColor, String sKU, String stock,
			Timestamp recordTime) {
		super();
		this.shop = shop;
		this.URL = uRL;
		this.ID = iD;
		this.totalSale = totalSale;
		this.tPrice = tPrice;
		this.name = name;
		this.pic = pic;
		this.brand = brand;
		this.material = material;
		this.season = season;
		this.color = color;
		this.sex = sex;
		this.fabric = fabric;
		this.style = style;
		this.paint = paint;
		this.huohao = huohao;
		this.qudao = qudao;
		this.oPrice = oPrice;
		this.sizeColor = sizeColor;
		this.SKU = sKU;
		this.stock = stock;
		this.recordTime = recordTime;
	}
	
/*	public TaobaoDto(String s, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9,
			String s10, String s11, String s12, String s13, String s14, String s15, String s16, String s17, String s18,
			String s19, String s20, String s21, Date date) {
		// TODO Auto-generated constructor stub
	}*/

	
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(String totalSale) {
		this.totalSale = totalSale;
	}
	public String gettPrice() {
		return tPrice;
	}
	public void settPrice(String tPrice) {
		this.tPrice = tPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPaint() {
		return paint;
	}
	public void setPaint(String paint) {
		this.paint = paint;
	}
	public String getHuohao() {
		return huohao;
	}
	public void setHuohao(String huohao) {
		this.huohao = huohao;
	}
	public String getQudao() {
		return qudao;
	}
	public void setQudao(String qudao) {
		this.qudao = qudao;
	}
	public String getoPrice() {
		return oPrice;
	}
	public void setoPrice(String oPrice) {
		this.oPrice = oPrice;
	}
	public String getSizeColor() {
		return sizeColor;
	}
	public void setSizeColor(String sizeColor) {
		this.sizeColor = sizeColor;
	}
	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sKU) {
		SKU = sKU;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public Timestamp getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}
	@Override
	public String toString() {
		return "TaobaoDto [shop=" + shop + ", URL=" + URL + ", ID=" + ID + ", totalSale=" + totalSale + ", tPrice="
				+ tPrice + ", name=" + name + ", pic=" + pic + ", brand=" + brand + ", material=" + material
				+ ", season=" + season + ", color=" + color + ", sex=" + sex + ", fabric=" + fabric + ", style=" + style
				+ ", paint=" + paint + ", huohao=" + huohao + ", qudao=" + qudao + ", oPrice=" + oPrice + ", sizeColor="
				+ sizeColor + ", SKU=" + SKU + ", stock=" + stock + ", recordTime=" + recordTime + "]";
	}
	

}
