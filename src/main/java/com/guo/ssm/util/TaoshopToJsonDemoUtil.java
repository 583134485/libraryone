package com.guo.ssm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import com.guo.ssm.dto.JsonDemoChildrenDto;
import com.guo.ssm.dto.JsonDemoDto;
import com.guo.ssm.model.Taobaoshop;

public class TaoshopToJsonDemoUtil {
	Logger log = Logger.getLogger(Class.class);

	public List<JsonDemoDto> ChangeToJsonDemoDto(List<Taobaoshop> taobaoshops) {
		List<JsonDemoDto> jsonDemoDtos = new ArrayList<JsonDemoDto>();
		log.info("开始转化");
		// long starttime = System.currentTimeMillis();
		
		// 构造map<key,map<key,map>> 构造可以继续思考，但暂时转化复杂
		Map<String, JsonDemoDto> jsondemodtomap = new HashMap<String, JsonDemoDto>();
		// Map<String,Map <String,JsonDemoChildrenDto> > jsondemomap=new
		// HashMap<String,Map <String,JsonDemoChildrenDto> >();
		for (Taobaoshop taobaoshop : taobaoshops) {
			List<JsonDemoChildrenDto> jsonDemoChildrenDtos = new ArrayList<JsonDemoChildrenDto>();
			JsonDemoChildrenDto jsonDemoChildrenDto = new JsonDemoChildrenDto();	
			List<String> chvalue = new ArrayList<String>();
			JsonDemoDto jsonDemoDto = new JsonDemoDto();
			String itemid = taobaoshop.getID();
			String value1 = taobaoshop.getTotalSale();
			String name = taobaoshop.getName();
			String tprice = taobaoshop.gettPrice();
			String stock = taobaoshop.getStock();
			String sku = taobaoshop.getSKU();
		//	log.info("判断");
			if (jsondemodtomap.containsKey(itemid)) {	
		//		log.info("添加新children-SKU");
				chvalue.add(value1);
				chvalue.add(tprice);
				chvalue.add(stock);
				jsonDemoChildrenDto.setValue(chvalue);
				jsonDemoChildrenDto.setName(name);
				jsonDemoChildrenDto.setId(sku);
				jsonDemoChildrenDto.setDiscretion(null);
				jsonDemoDto = jsondemodtomap.get(itemid);			
				// 使用get,set方法
				jsonDemoChildrenDtos = jsonDemoDto.getChildren();
				if(jsonDemoChildrenDtos==null){
					jsonDemoChildrenDtos= new ArrayList<JsonDemoChildrenDto>();
				}
				//log.info("getchilren" + jsonDemoChildrenDtos);
				//报错空指针
				jsonDemoChildrenDtos.add(jsonDemoChildrenDto);				
				jsonDemoDto.setChildren(jsonDemoChildrenDtos);
				// log.info(jsonDemoDto);
				//jsonDemoDto.addChildren(jsonDemoChildrenDto);
				// log.info(jsonDemoDto);
				jsondemodtomap.replace(itemid, jsonDemoDto);
				// log.info(jsondemodtomap);
			} else {
			//	log.info("建立新商品-id");
				List<String> value = new ArrayList<String>();
				value.add(value1);
				value.add(null);
				value.add(null);
				jsonDemoDto.setValue(value);
				jsonDemoDto.setName(name);
				jsonDemoDto.setId(itemid);
				jsonDemoDto.setDiscretion(null);
			//	log.info("建立新商品的第一一个children");
				//children			
				chvalue.add(value1);
				chvalue.add(tprice);
				chvalue.add(stock);
				jsonDemoChildrenDto.setValue(chvalue);
				jsonDemoChildrenDto.setName(name);
				jsonDemoChildrenDto.setId(sku);
				jsonDemoChildrenDto.setDiscretion(null);
				//log.info("22");
				//jsonDemoDto = jsondemodtomap.get(itemid);			
				// 使用get,set方法
				jsonDemoChildrenDtos = jsonDemoDto.getChildren();
				if(jsonDemoChildrenDtos==null){
					jsonDemoChildrenDtos= new ArrayList<JsonDemoChildrenDto>();
				}
				//log.info("11");
				//log.info("getchilren" + jsonDemoChildrenDtos);
				//报错空指针
				jsonDemoChildrenDtos.add(jsonDemoChildrenDto);				
				jsonDemoDto.setChildren(jsonDemoChildrenDtos);
				jsondemodtomap.put(itemid, jsonDemoDto);
				//log.info(jsondemodtomap);
			}
		}
		for (JsonDemoDto jsonDemoDto2 : jsondemodtomap.values()) {
			jsonDemoDtos.add(jsonDemoDto2);
		}
		return jsonDemoDtos;
	}

}
