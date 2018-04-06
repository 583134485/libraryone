package com.guo.ssm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.guo.ssm.dto.ShengejingDto;

//计算后得出相应的dto
public class ShengejingDtoCountUtil {
	
	Logger logger=Logger.getLogger(Class.class);
	//一家店一段时间内的data,通过dto 拆解累加
	public ShengejingDto ShengejingDtoPlus(List<ShengejingDto> shengejingDtos) throws Exception{
		StringCountUtil stringCountUtil=new StringCountUtil();
		String shop=new String();
		//时间集合
		List <String> datelist=new ArrayList<String>();
		//首先建立全局变量
		HashMap<String,HashMap<String,String>> data=new HashMap<String,HashMap<String,String>>();
		for(ShengejingDto shengejingDto:shengejingDtos){
			String recordtime=shengejingDto.getRecordtime();
			datelist.add(recordtime);
			//这if的语句执行次数最少，把get语句放这里
			 shop=shengejingDto.getShop();
			HashMap<String,HashMap <String,String>> typedata=shengejingDto.getTypedata();
			
			for(String type:typedata.keySet()){
				//存放到新的map
				//新集合不存在
				if(!data.containsKey(type)){
			
					
					//一共的时间段
					
					data.put(type, typedata.get(type));
					//logger.info(data);
				}
				//新集合存在type时
				else {
					
					HashMap<String, String> number=typedata.get(type);
					String pc=number.get("pc");
					String app=number.get("app");
					String hotword=number.get("hotword");
					
					HashMap<String , String> newnumber=data.get(type);
					String newpc=newnumber.get("pc");
					String newapp=newnumber.get("app");
					String newhotword=newnumber.get("hotword");
					//累加
					 newpc=stringCountUtil.StringPlusToString(pc, newpc);
					 newapp=stringCountUtil.StringPlusToString(app, newapp);
					 newhotword=stringCountUtil.StringPlusToString(newhotword,hotword);
					
					 newnumber.put("pc", newpc);
					 newnumber.put("app", newapp);
					 newnumber.put("hotword", newhotword);
					 
					 data.put(type, newnumber);
					// logger.info(data);
					 	
					
				}
				
			}
		}
		ShengejingDto shengejingDtonew=new ShengejingDto();
		shengejingDtonew.setShop(shop);
		logger.info(datelist);
		logger.info(stringCountUtil.StringDateListToString(datelist));
		shengejingDtonew.setRecordtime(stringCountUtil.StringDateListToString(datelist));
	
		shengejingDtonew.setTypedata(data);
		return shengejingDtonew;
	}

}
