package com.guo.ssm.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.guo.ssm.dto.ShengejingDto;
import com.guo.ssm.model.ShengejingModel;

public class ShengejingModelToDtoUtil {
	Logger logger=Logger.getLogger(Class.class);
	
	TimeDateUtil timeDateUtil=new TimeDateUtil();
	
	//一家店某一天的数据统计
	public ShengejingDto changeOneDayModeltoDto(List<ShengejingModel> shengejingModels){
		StringCountUtil stringCountUtil=new StringCountUtil();
		//dto
		ShengejingDto shengejingDto=new ShengejingDto();
		//data要作为全局变量,new的位置和不只影响时间，还会逻辑错误，中途不小心被其他new了
		HashMap<String,HashMap<String,String>> data=new HashMap<String,HashMap<String,String>>();
		for(ShengejingModel shengejingModel:shengejingModels){

			String id=shengejingModel.getId();
			String name=shengejingModel.getName();
			String hotword=shengejingModel.getHotword();
			String pc=shengejingModel.getPc();
			String app=shengejingModel.getApp();
			String shop=shengejingModel.getShop();
			String type=shengejingModel.getType();
			Timestamp uptime=shengejingModel.getUptime();
			Timestamp recordtime=shengejingModel.getRecordtime();	
			//type null是特殊数据
			//String 的判空注意
			if(type.isEmpty()){
				//logger.info("null");
			}
			else{
				//logger.info("不为空");
				//不存在type
				if(!data.containsKey(type)){
				//	logger.info("不存在type"+type);
				  //！错误操作  data=new HashMap<String,HashMap<String,String>>();
					HashMap<String, String> number=new HashMap<String,String>();
					number.put("app", app);
					number.put("pc", pc);
					number.put("hotword", hotword);
					data.put(type, number);
				//	logger.info("data:"+data);
				}
				//存在
				else{
				//	logger.info("存在"+type);
					 //!错误操作data=shengejingDto.getTypedata();
					HashMap<String, String> number=data.get(type);
					String oldapp=number.get("app");
					String oldpc=number.get("pc");
					String oldhotword=number.get("hotword");
					//累加
			
					number.put("app", stringCountUtil.StringPlusToString(oldapp, app));
					number.put("pc", stringCountUtil.StringPlusToString(oldpc, pc));
					number.put("hotword", stringCountUtil.StringPlusToString(oldhotword, hotword));
					//更新data
					data.put(type, number);	
					//logger.info("累加更新"+data);
				}
				
				
				
			}
			
			shengejingDto.setShop(shop);
			shengejingDto.setRecordtime(timeDateUtil.TimestampToSimpleDate(recordtime));
			shengejingDto.setTypedata(data);
			
			
		}
		
		return shengejingDto;
	}
	//一家店一段的数据统计
	public ShengejingDto changeLongDayModeltoDto(List<ShengejingModel> shengejingModels){
		StringCountUtil stringCountUtil=new StringCountUtil();
		//dto
		ShengejingDto shengejingDto=new ShengejingDto();
		//data要作为全局变量,new的位置和不只影响时间，还会逻辑错误，中途不小心被其他new了
		HashMap<String,HashMap<String,String>> data=new HashMap<String,HashMap<String,String>>();
		
		List<String> datelist= new ArrayList<String>();
		for(ShengejingModel shengejingModel:shengejingModels){

			String id=shengejingModel.getId();
			String name=shengejingModel.getName();
			String hotword=shengejingModel.getHotword();
			String pc=shengejingModel.getPc();
			String app=shengejingModel.getApp();
			String shop=shengejingModel.getShop();
			String type=shengejingModel.getType();
			Timestamp uptime=shengejingModel.getUptime();
			Timestamp recordtime=shengejingModel.getRecordtime();
			String record=timeDateUtil.TimestampToSimpleDate(recordtime);
			//用list 重复传入没有意义
			if(!datelist.contains(record)){
				datelist.add(record);
			}
			
			//type null是特殊数据
			//String 的判空注意
			if(type.isEmpty()){
				//logger.info("null");
			}
			else{
				//logger.info("不为空");
				//不存在type
				if(!data.containsKey(type)){
					//记录recordtime
				
				//	logger.info("不存在type"+type);
				  //！错误操作  data=new HashMap<String,HashMap<String,String>>();
					HashMap<String, String> number=new HashMap<String,String>();
					number.put("app", app);
					number.put("pc", pc);
					number.put("hotword", hotword);
					data.put(type, number);
				//	logger.info("data:"+data);
				}
				//存在
				else{
				//	logger.info("存在"+type);
					 //!错误操作data=shengejingDto.getTypedata();
					HashMap<String, String> number=data.get(type);
					String oldapp=number.get("app");
					String oldpc=number.get("pc");
					String oldhotword=number.get("hotword");
					//累加
			
					number.put("app", stringCountUtil.StringPlusToString(oldapp, app));
					number.put("pc", stringCountUtil.StringPlusToString(oldpc, pc));
					number.put("hotword", stringCountUtil.StringPlusToString(oldhotword, hotword));
					//更新data
					data.put(type, number);	
					//logger.info("累加更新"+data);
				}
				
				
				
			}
			
	
			shengejingDto.setShop(shop);
			
		}
		
		
		try {
			logger.info(datelist.size());
			shengejingDto.setRecordtime(timeDateUtil.StringDateListToString(datelist));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		shengejingDto.setTypedata(data);
		return shengejingDto;
	}

}
