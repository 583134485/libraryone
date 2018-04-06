package com.guo.ssm.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.guo.ssm.model.NewGoodsModel;
import com.guo.ssm.model.NewHotGoodsModel;

public class DtoToModelUtil {
	Logger logger=Logger.getLogger(Class.class);
	
   public List<NewGoodsModel> changeManyDtoToModel(List<NewHotGoodsModel> newHotGoodsModels){
	   List<NewGoodsModel> newGoodsModels=new ArrayList<NewGoodsModel>();
	   //以下有多个循环，将变量放在哪个循环内和循环外，不放好会丢失数据
	   for(NewHotGoodsModel newHotGoodsModel:newHotGoodsModels){
		   logger.info("进入一类商品");
		   NewGoodsModel newGoodsModel=new NewGoodsModel();
	    	List<String> datatime=newHotGoodsModel.getDatatime();
	    	List <Integer> flow=newHotGoodsModel.getFlow();
	    	List <Integer> plus =newHotGoodsModel.getPlus();
	    	List <Integer> money=newHotGoodsModel.getMoney();
	    	List<Integer> price=newHotGoodsModel.getPrice();
	    	List <String> purchaseRate=newHotGoodsModel.getPurchaseRate();
	    	List <String> conversion=newHotGoodsModel.getConversion();
	    	List <Integer> payment=newHotGoodsModel.getPayment();
	    	  String id=newHotGoodsModel.getId();
	    	  String styleNumber=newHotGoodsModel.getStyleNumber();
	    	  String pictureUrl=newHotGoodsModel.getPictureUrl();
	    	  int tagPrice=newHotGoodsModel.getTagPrice();
	    	  int  Newquotation=newHotGoodsModel.getNewquotation();
	    	  String discount=newHotGoodsModel.getDiscount();
	    	  String fabric=newHotGoodsModel.getFabric();
	    	  String typeVersion=newHotGoodsModel.getTypeVersion();
	    	  String year=newHotGoodsModel.getYear();
	    	  String season=newHotGoodsModel.getSeason();
	    	  String brand=newHotGoodsModel.getBrand();
	    	  String productLine=newHotGoodsModel.getProductLine();
	    	  String category=newHotGoodsModel.getCategory();
	    		
	    	//前提是list的大小size一样，不然会报错
	    	for(int i=0;i<datatime.size();i++){
	    		newGoodsModel.setDatatime(datatime.get(i));
	    		newGoodsModel.setFlow(flow.get(i));
	    		newGoodsModel.setPlus(plus.get(i));
	    		newGoodsModel.setMoney(money.get(i));
	    		newGoodsModel.setPrice(price.get(i));
	    		newGoodsModel.setPurchaseRate(purchaseRate.get(i));
	    		newGoodsModel.setConversion(conversion.get(i));
	    		newGoodsModel.setPayment(payment.get(i));
	    		//以下非集合
	    		newGoodsModel.setId(id);
	    		newGoodsModel.setStyleNumber(styleNumber);
	    		newGoodsModel.setPictureUrl(pictureUrl);
	    		newGoodsModel.setTagPrice(tagPrice);
	    		newGoodsModel.setNewquotation(Newquotation);
	    		newGoodsModel.setDiscount(discount);
	    		newGoodsModel.setFabric(fabric);
	    		newGoodsModel.setTypeVersion(typeVersion);
	    		newGoodsModel.setYear(year);
	    		newGoodsModel.setSeason(season);
	    		newGoodsModel.setBrand(brand);
	    		newGoodsModel.setProductLine(productLine);
	    		newGoodsModel.setCategory(category);
	    		//以下是非集合
	    		newGoodsModels.add(newGoodsModel);
	    		newGoodsModel=new NewGoodsModel();
	    		logger.info("添加一条");
	    	}
	    	
	    
	    }
	   return newGoodsModels;
   }

   public List<NewGoodsModel> changeOneDtoToModel(NewHotGoodsModel newHotGoodsModel){
	   List<NewGoodsModel> newGoodsModels=new ArrayList<NewGoodsModel>();
	   //以下有多个循环，将变量放在哪个循环内和循环外，不放好会丢失数据
		   logger.info("进入一类商品");
		   NewGoodsModel newGoodsModel=new NewGoodsModel();
	    	List<String> datatime=newHotGoodsModel.getDatatime();
	    	List <Integer> flow=newHotGoodsModel.getFlow();
	    	List <Integer> plus =newHotGoodsModel.getPlus();
	    	List <Integer> money=newHotGoodsModel.getMoney();
	    	List<Integer> price=newHotGoodsModel.getPrice();
	    	List <String> purchaseRate=newHotGoodsModel.getPurchaseRate();
	    	List <String> conversion=newHotGoodsModel.getConversion();
	    	List <Integer> payment=newHotGoodsModel.getPayment();
	    	  String id=newHotGoodsModel.getId();
	    	  String styleNumber=newHotGoodsModel.getStyleNumber();
	    	  String pictureUrl=newHotGoodsModel.getPictureUrl();
	    	  int tagPrice=newHotGoodsModel.getTagPrice();
	    	  int  Newquotation=newHotGoodsModel.getNewquotation();
	    	  String discount=newHotGoodsModel.getDiscount();
	    	  String fabric=newHotGoodsModel.getFabric();
	    	  String typeVersion=newHotGoodsModel.getTypeVersion();
	    	  String year=newHotGoodsModel.getYear();
	    	  String season=newHotGoodsModel.getSeason();
	    	  String brand=newHotGoodsModel.getBrand();
	    	  String productLine=newHotGoodsModel.getProductLine();
	    	  String category=newHotGoodsModel.getCategory();
	    		
	    	//前提是list的大小size一样，不然会报错
	    	for(int i=0;i<datatime.size();i++){
	    		newGoodsModel.setDatatime(datatime.get(i));
	    		newGoodsModel.setFlow(flow.get(i));
	    		newGoodsModel.setPlus(plus.get(i));
	    		newGoodsModel.setMoney(money.get(i));
	    		newGoodsModel.setPrice(price.get(i));
	    		newGoodsModel.setPurchaseRate(purchaseRate.get(i));
	    		newGoodsModel.setConversion(conversion.get(i));
	    		newGoodsModel.setPayment(payment.get(i));
	    		//以下非集合
	    		newGoodsModel.setId(id);
	    		newGoodsModel.setStyleNumber(styleNumber);
	    		newGoodsModel.setPictureUrl(pictureUrl);
	    		newGoodsModel.setTagPrice(tagPrice);
	    		newGoodsModel.setNewquotation(Newquotation);
	    		newGoodsModel.setDiscount(discount);
	    		newGoodsModel.setFabric(fabric);
	    		newGoodsModel.setTypeVersion(typeVersion);
	    		newGoodsModel.setYear(year);
	    		newGoodsModel.setSeason(season);
	    		newGoodsModel.setBrand(brand);
	    		newGoodsModel.setProductLine(productLine);
	    		newGoodsModel.setCategory(category);
	    		//以下是非集合
	    		newGoodsModels.add(i, newGoodsModel);
	    		//这句一定要加，防止被覆盖
	    		   newGoodsModel=new NewGoodsModel();
	    		logger.info("添加一条的newgoodsmodel"+newGoodsModel.getDatatime());
	    		for(NewGoodsModel newGoodsModel2:newGoodsModels){
	    			logger.info("每一次添加后的"+newGoodsModel2.getDatatime()+"//"+newGoodsModel2.getFlow()+"//");
	    		}
	    	
	    	}
	    	
	    
	    
	   return newGoodsModels;
   }
	
}
