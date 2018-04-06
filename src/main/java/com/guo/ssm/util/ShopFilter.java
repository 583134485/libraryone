package com.guo.ssm.util;

import java.nio.charset.MalformedInputException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.guo.ssm.model.Taobaoshop;
//简单的去重SKU与时间最新
public class ShopFilter {
	Logger logger=Logger.getLogger(Class.class);
	
	public List<Taobaoshop> shopfilter(List<Taobaoshop> taobaoshops ){
	logger.info("开始转化");
	long a=System.currentTimeMillis();
		List<Taobaoshop> taobaoshops2=new ArrayList<Taobaoshop>();
		//taoshop不重复的数据结构
		Map<String, Taobaoshop> skumap=new HashMap<String,Taobaoshop>();
		for(Taobaoshop taobaoshop:taobaoshops){
			String SKU=taobaoshop.getSKU();
			Timestamp recordTime=taobaoshop.getRecordTime();
			if(skumap.containsKey(SKU)){
				if(skumap.get(SKU).getRecordTime().before(recordTime)){
					skumap.replace(SKU, taobaoshop);		
				}	
			}
			else{
				skumap.put(SKU, taobaoshop);
			}
	}
		
		 for(Taobaoshop taobaoshop:skumap.values()){
			 taobaoshops2.add(taobaoshop);
		 }
		 long b=System.currentTimeMillis();
		logger.info("转化成功花费"+(b-a)+"ms");
		return taobaoshops2;
	}
//list<map<map>>表达过于繁琐
/*	public List<Taobaoshop> shopfilter(List<Taobaoshop> taobaoshops ){
		//taoshop不重复的数据结构
		List<Map<String,Map<String, Taobaoshop>>> listmapmapshop=new ArrayList<Map<String,Map<String, Taobaoshop>>>();
		Map<String, Taobaoshop> skumap=new HashMap<String,Taobaoshop>();
		for(Taobaoshop taobaoshop:taobaoshops){
			String ID=taobaoshop.getID();
			String SKU=taobaoshop.getSKU();
			Timestamp recordTime=taobaoshop.getRecordTime();	
	}
		return null;
	}
	
	*/
	
	//用list<object> 不能到特定的指定的值
	/*public List<Taobaoshop> shopfilter(List<Taobaoshop > taobaoshops ){
		List<Taobaoshop> taobaoshops2=new ArrayList<Taobaoshop>();
		for(Taobaoshop taobaoshop:taobaoshops){
			String ID=taobaoshop.getID();
			String  SKU=taobaoshop.getSKU();
			Timestamp recordTime=taobaoshop.getRecordTime();
			if(taobaoshops2.contains(ID)){
				
				if(taobaoshops2.contains(SKU)){
					
					
					
				}
				else{
					taobaoshops2.add(taobaoshop);
				}
			}
			else{
				taobaoshops2.add(taobaoshop);
			}
		}
		
		return null;
		
	}*/
	
	 
	
}
