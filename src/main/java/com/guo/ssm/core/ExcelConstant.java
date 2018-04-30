package com.guo.ssm.core;

import java.util.ArrayList;
import java.util.List;

public class ExcelConstant {

	public static List<String> name=new ArrayList<String>();
	
	public static List<String> getname() {
		setname();
		return name;
	}
	
	public static void setname() {
		name.add("所属终端");
		name.add("商品id");
		name.add("商品标题");
		name.add("商品在线状态");
		name.add("商品链接");
		name.add("浏览量");
		name.add("访客数");
		name.add("平均停留时长");
		name.add("详情页跳出率");
		name.add("下单转化率");		
		name.add("下单支付转化率");
		name.add("支付转化率");
		name.add("下单金额");
		name.add("下单商品件数");
		name.add("下单买家数");
		name.add("支付金额");
		name.add("支付商品件数");
		name.add("加购件数");		
		name.add("访客平均价值");
		name.add("点击次数");
		name.add("点击率");
		name.add("曝光量");
		name.add("收藏人数");
		name.add("搜索引导支付买家数");
		name.add("客单价");
		name.add("搜索支付转化率");
		name.add("搜索引导访客数");
		name.add("支付买家数");
		name.add("售中售后成功退款金额");
		name.add("售中售后成功退款笔数");
	}

}
