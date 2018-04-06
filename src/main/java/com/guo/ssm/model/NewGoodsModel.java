package com.guo.ssm.model;

import java.io.Serializable;
import java.util.List;

public class NewGoodsModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//图片
	public String pictureUrl;	
//ID
  public String id;
//款号
  public String styleNumber;
  //吊牌价
  public  int tagPrice;
  //上新价
  public  int Newquotation;
  //折扣
  public  String discount;
  //品类
  public String  category;
  //面料
  public String fabric;
  //版型
  public String typeVersion;
  //年份
  public String year;
  //季节
  public String season;
  //品牌
  public String brand;
  //产品线
  public String productLine;
  //日期
  public String datatime;
  //流量
  public Integer flow;
  //支付
  public Integer payment;
  //加购
  public Integer plus;
  //金额
  public Integer money;
  //加购率
  public String purchaseRate;
  //转化率
  public String conversion;
  //单价
  public Integer price;
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStyleNumber() {
		return styleNumber;
	}
	public void setStyleNumber(String styleNumber) {
		this.styleNumber = styleNumber;
	}
	public int getTagPrice() {
		return tagPrice;
	}
	public void setTagPrice(int tagPrice) {
		this.tagPrice = tagPrice;
	}
	public int getNewquotation() {
		return Newquotation;
	}
	public void setNewquotation(int newquotation) {
		Newquotation = newquotation;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
	public String getTypeVersion() {
		return typeVersion;
	}
	public void setTypeVersion(String typeVersion) {
		this.typeVersion = typeVersion;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductLine() {
		return productLine;
	}
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}
	public String getDatatime() {
		return datatime;
	}
	public void setDatatime(String datatime) {
		this.datatime = datatime;
	}
	public Integer getFlow() {
		return flow;
	}
	public void setFlow(Integer flow) {
		this.flow = flow;
	}
	public Integer getPayment() {
		return payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	public Integer getPlus() {
		return plus;
	}
	public void setPlus(Integer plus) {
		this.plus = plus;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getPurchaseRate() {
		return purchaseRate;
	}
	public void setPurchaseRate(String purchaseRate) {
		this.purchaseRate = purchaseRate;
	}
	public String getConversion() {
		return conversion;
	}
	public void setConversion(String conversion) {
		this.conversion = conversion;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "NewGoodsModel [pictureUrl=" + pictureUrl + ", id=" + id + ", styleNumber=" + styleNumber + ", tagPrice="
				+ tagPrice + ", Newquotation=" + Newquotation + ", discount=" + discount + ", category=" + category
				+ ", fabric=" + fabric + ", typeVersion=" + typeVersion + ", year=" + year + ", season=" + season
				+ ", brand=" + brand + ", productLine=" + productLine + ", datatime=" + datatime + ", flow=" + flow
				+ ", payment=" + payment + ", plus=" + plus + ", money=" + money + ", purchaseRate=" + purchaseRate
				+ ", conversion=" + conversion + ", price=" + price + "]";
	}

	
}
