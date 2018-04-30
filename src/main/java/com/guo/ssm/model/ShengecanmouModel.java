package com.guo.ssm.model;

import java.io.Serializable;
import java.sql.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * model shengecanmou
 */
public class ShengecanmouModel implements Serializable {
	private static final long serialVersionUID = 1L;
    //空构造
	public ShengecanmouModel(){};
	//构造方便测试...
	public ShengecanmouModel(Date recordtime, String id, String title, String terminal, String state, String url,
			String views, String visitors, String staytime, String detailspage, String orderconrate, String payconrate,
			String payamount, String paygoods, String paybuyers, String orderpayconrate, String orderamount,
			String ordergoods, String orderbuyers, String purchase, String visitorsvalue, String clicktimes,
			String clickrate, String exposure, String collection, String unitprice, String searchbuyers,
			String searchpay, String searchvisitors, String refundamount, String refundnumbers) {
		super();
		this.recordtime = recordtime;
		this.id = id;
		this.title = title;
		this.terminal = terminal;
		this.state = state;
		this.url = url;
		this.views = views;
		this.visitors = visitors;
		this.staytime = staytime;
		this.detailspage = detailspage;
		this.orderconrate = orderconrate;
		this.payconrate = payconrate;
		this.payamount = payamount;
		this.paygoods = paygoods;
		this.paybuyers = paybuyers;
		this.orderpayconrate = orderpayconrate;
		this.orderamount = orderamount;
		this.ordergoods = ordergoods;
		this.orderbuyers = orderbuyers;
		this.purchase = purchase;
		this.visitorsvalue = visitorsvalue;
		this.clicktimes = clicktimes;
		this.clickrate = clickrate;
		this.exposure = exposure;
		this.collection = collection;
		this.unitprice = unitprice;
		this.searchbuyers = searchbuyers;
		this.searchpay = searchpay;
		this.searchvisitors = searchvisitors;
		this.refundamount = refundamount;
		this.refundnumbers = refundnumbers;
	}
	// 记录日期sql.date这里用
	//fastjson默认把Date类型转换成long(一长串数字) 前端会出现一串数字。。
	@JSONField (format="yyyy-MM-dd")
	public Date recordtime;
	// 商品ID
	public String id;
	// 商品标题
	public String title;
	// 所属终端
	public String terminal;
	// 商品在线状态
	public String state;
	// 商品连接
	public String url;
	// 浏览量
	public String views;
	// 访客数
	public String visitors;
	// 平均停留时长
	public String staytime;
	// 详情页跳出率
	public String detailspage;
	// 下单转化率
	public String orderconrate;
	// 支付转化率
	public String payconrate;
	// 支付金额
	public String payamount;
	// 支付商品件数
	public String paygoods;
	// 支付买家数
	public String paybuyers;
	// 下单支付转化率
	public String orderpayconrate;
	// 下单金额
	public String orderamount;
	// 下单商品件数
	public String ordergoods;
	// 下单买家数
	public String orderbuyers;
	// 加购件数
	public String purchase;
	// 访客平均价值
	public String visitorsvalue;
	// 点击次数
	public String clicktimes;
	// 点击率
	public String clickrate;
	// 曝光率
	public String exposure;
	// 搜藏人数
	public String collection;
	// 客单价
	public String unitprice;
	// 搜索引导的买家数
	public String searchbuyers;
	// 搜索支付转化率
	public String searchpay;
	// 搜索引导访客数
	public String searchvisitors;
	// 退款金额
	public String refundamount;
	// 退关笔数
	public String refundnumbers;

	@Override
	public String toString() {
		return "ShengecanmouModel [recordtime=" + recordtime + ", id=" + id + ", title=" + title + ", terminal="
				+ terminal + ", state=" + state + ", url=" + url + ", views=" + views + ", visitors=" + visitors
				+ ", staytime=" + staytime + ", detailspage=" + detailspage + ", orderconrate=" + orderconrate
				+ ", payconrate=" + payconrate + ", payamount=" + payamount + ", paygoods=" + paygoods + ", paybuyers="
				+ paybuyers + ", orderpayconrate=" + orderpayconrate + ", orderamount=" + orderamount + ", ordergoods="
				+ ordergoods + ", orderbuyers=" + orderbuyers + ", purchase=" + purchase + ", visitorsvalue="
				+ visitorsvalue + ", clicktimes=" + clicktimes + ", clickrate=" + clickrate + ", exposure=" + exposure
				+ ", collection=" + collection + ", unitprice=" + unitprice + ", searchbuyers=" + searchbuyers
				+ ", searchpay=" + searchpay + ", searchvisitors=" + searchvisitors + ", refundamount=" + refundamount
				+ ", refundnumbers=" + refundnumbers + "]";
	}

	public Date getRecordtime() {
		return recordtime;
	}

	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getViews() {
		return views;
	}

	public void setViews(String views) {
		this.views = views;
	}

	public String getVisitors() {
		return visitors;
	}

	public void setVisitors(String visitors) {
		this.visitors = visitors;
	}

	public String getStaytime() {
		return staytime;
	}

	public void setStaytime(String staytime) {
		this.staytime = staytime;
	}

	public String getDetailspage() {
		return detailspage;
	}

	public void setDetailspage(String detailspage) {
		this.detailspage = detailspage;
	}

	public String getOrderconrate() {
		return orderconrate;
	}

	public void setOrderconrate(String orderconrate) {
		this.orderconrate = orderconrate;
	}

	public String getPayconrate() {
		return payconrate;
	}

	public void setPayconrate(String payconrate) {
		this.payconrate = payconrate;
	}

	public String getPayamount() {
		return payamount;
	}

	public void setPayamount(String payamount) {
		this.payamount = payamount;
	}

	public String getPaygoods() {
		return paygoods;
	}

	public void setPaygoods(String paygoods) {
		this.paygoods = paygoods;
	}

	public String getPaybuyers() {
		return paybuyers;
	}

	public void setPaybuyers(String paybuyers) {
		this.paybuyers = paybuyers;
	}

	public String getOrderpayconrate() {
		return orderpayconrate;
	}

	public void setOrderpayconrate(String orderpayconrate) {
		this.orderpayconrate = orderpayconrate;
	}

	public String getOrderamount() {
		return orderamount;
	}

	public void setOrderamount(String orderamount) {
		this.orderamount = orderamount;
	}

	public String getOrdergoods() {
		return ordergoods;
	}

	public void setOrdergoods(String ordergoods) {
		this.ordergoods = ordergoods;
	}

	public String getOrderbuyers() {
		return orderbuyers;
	}

	public void setOrderbuyers(String orderbuyers) {
		this.orderbuyers = orderbuyers;
	}

	public String getPurchase() {
		return purchase;
	}

	public void setPurchase(String purchase) {
		this.purchase = purchase;
	}

	public String getVisitorsvalue() {
		return visitorsvalue;
	}

	public void setVisitorsvalue(String visitorsvalue) {
		this.visitorsvalue = visitorsvalue;
	}

	public String getClicktimes() {
		return clicktimes;
	}

	public void setClicktimes(String clicktimes) {
		this.clicktimes = clicktimes;
	}

	public String getClickrate() {
		return clickrate;
	}

	public void setClickrate(String clickrate) {
		this.clickrate = clickrate;
	}

	public String getExposure() {
		return exposure;
	}

	public void setExposure(String exposure) {
		this.exposure = exposure;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}

	public String getSearchbuyers() {
		return searchbuyers;
	}

	public void setSearchbuyers(String searchbuyers) {
		this.searchbuyers = searchbuyers;
	}

	public String getSearchpay() {
		return searchpay;
	}

	public void setSearchpay(String searchpay) {
		this.searchpay = searchpay;
	}

	public String getSearchvisitors() {
		return searchvisitors;
	}

	public void setSearchvisitors(String searchvisitors) {
		this.searchvisitors = searchvisitors;
	}

	public String getRefundamount() {
		return refundamount;
	}

	public void setRefundamount(String refundamount) {
		this.refundamount = refundamount;
	}

	public String getRefundnumbers() {
		return refundnumbers;
	}

	public void setRefundnumbers(String refundnumbers) {
		this.refundnumbers = refundnumbers;
	}

}
