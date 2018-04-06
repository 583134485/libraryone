package com.guo.ssm.util;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.MidiDevice.Info;



import org.apache.commons.collections.functors.MapTransformer;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;

import com.alibaba.druid.support.logging.Log;
import com.guo.ssm.dto.Brand_Sale;
//brand-sale累加
public class Brand_SaleCount {
	Logger log=Logger.getLogger(Class.class);
	 
	
/*	List <Brand_Sale> alist=null;*/
	Map <String,String> map=new HashMap<String,String>();

	
  public   Map<String, String> count(List <Brand_Sale> list){
	  log.info("开始累加");
	  long starttime=System.currentTimeMillis();
	  int num=0; 
	  int a=0,b=0,c=0;
	  for (Brand_Sale brand_Sale : list) {
		  num=num+1;
		  String brand=brand_Sale.brand;
		  String totalSale=brand_Sale.totalSale;
		  String wu=new String("无");
		/*  log.info(totalSale);*/
		  //不能使用‘==’ 不能判断
		 if(totalSale.equals(wu)){
		/*	 log.info("测dao0");*/
			 totalSale=new String("0");
		 }
		  if(map.containsKey(brand)){

			Integer one=new Integer(totalSale);
	/*		log.info("替换total"+one);*/
			  Integer two =new Integer(map.get(brand));			 
			   a= one.intValue();			  
			   b= two.intValue();
		      c=a+b;
			  String ttsale=String.valueOf(c);			 
			map.replace(brand, ttsale);			
		  }
		  else{
			 map.put(brand, totalSale);			 
		  }
		  
/*		  log.info("第"+num+map.toString());*/
	}
	  long endtime=System.currentTimeMillis();
	  log.info("加累结束费时"+(endtime-starttime));
	  return map;
	 
	  
	   
   }
}
