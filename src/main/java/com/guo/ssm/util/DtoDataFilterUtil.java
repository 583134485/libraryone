

package com.guo.ssm.util;
/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月18日 下午4:54:28
* @version 1.0 
* @parameter  
* @Description: TODO(主要用作 list 等集合数据的过滤筛选) 
* @since  
* @return  */



import java.util.List;

import org.apache.log4j.Logger;

import com.guo.ssm.model.ShengecanmouModel;
import com.guo.ssm.model.ShengejingModel;

public class DtoDataFilterUtil {
	Logger logger=Logger.getLogger(getClass());
	//对一段时间的 某 一个 字段的 累加 
	//这种是通过 java 端 累加 其实 可以mysql 代替 进行累加
	public List<ShengejingModel> plusShengecanmou(List<ShengejingModel> shengejingModels){
		 	
		return null;
	}
	

	
	//主要对shengejingmodel 很微小的 占比例很小的 数据 的 去除  echarts 一股脑的显示 数据 很杂乱
	//这个也可已在数据库完成 order by+ limit
	public List<ShengejingModel> delLittleDataShengejingModel(List<ShengejingModel>shengejingModels,String limit){
		
		return null;
	}
	
	//写一个 通用 筛选 类 有点不现实  因为类都不一样。。。
	
/*	
	public List<T> delLittleData(List<T> ts){
		return null;
	}*/
	
	//主要  shengejingmodel 对数据 进行排序
	public List<ShengejingModel> oderDataShengejingModel(List<ShengejingModel> shengejingModels){
		
		return null;
	}
	
	//由于 mysql 处理不了 varchar 10% 的累加
	public ShengecanmouModel averageconversion(List<ShengecanmouModel> shengecanmouModels){
		//最后的平均值 
		ShengecanmouModel averageshengecanmouModel=new ShengecanmouModel();
		//util
		StringDaoUtil stringDaoUtil=new StringDaoUtil();
		Double detailspage=(double) 0;
		//double null error
		//Double doublespage=null;
		Double orderconrate=(double) 0;
		Double payconrate=(double) 0;
		double num=1;
		//i 的遍历 放便 计数 求平均 值  好像也不是必须的  
	/*	for(int i=1;i<=shengecanmouModels.size();i++){
			
			detailspage+=stringDaoUtil.StringToDouble(shengecanmouModels.get(i).getDetailspage());
			orderconrate+=stringDaoUtil.StringToDouble(shengecanmouModels.get(i).getOrderconrate());
			payconrate+=stringDaoUtil.StringToDouble(shengecanmouModels.get(i).getPayconrate());
		}*/
		//这样应该快些
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			num++;
			detailspage+=stringDaoUtil.StringToDouble(shengecanmouModel.getDetailspage());
			orderconrate+=stringDaoUtil.StringToDouble(shengecanmouModel.getOrderconrate());
			payconrate+=stringDaoUtil.StringToDouble(shengecanmouModel.getPayconrate());
		}
/*		String averdetail=Double.toString(detailspage/num)+"%";
		String averorder=Double.toString(orderconrate/num)+"%";
		String averpay=Double.toString(payconrate/num)+"%";*/
		//logger.info(detailspage+"//"+orderconrate+"//"+payconrate+"//"+num);
		//保留两位小数
		String averdetail=String.format("%.2f", detailspage/num);
		String averorder=String.format("%.2f", orderconrate/num);
		String averpay=String.format("%.2f", payconrate/num);
/*		String averdetail=Double.toString(detailspage/num);
		String averorder=Double.toString(orderconrate/num);
		String averpay=Double.toString(payconrate/num);*/
		averageshengecanmouModel.setId(shengecanmouModels.get(0).getId());
		averageshengecanmouModel.setTitle(shengecanmouModels.get(0).getTitle());
		averageshengecanmouModel.setDetailspage(averdetail);
		averageshengecanmouModel.setOrderconrate(averorder);
		averageshengecanmouModel.setPayconrate(averpay);
	   
		return averageshengecanmouModel;
	}
	
	//无法解决动态  找到 属性（） 用 强大的sql 语句代替...
	public List<ShengecanmouModel>ShengecanmouDoubleFormat(List<ShengecanmouModel>shengecanmouModels){
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			
		}
		return null;
	}
	
	public List<ShengecanmouModel>ShengecanmouTitleDel(List<ShengecanmouModel>shengecanmouModels){
		
		return null;
	}
	
	
	
}
