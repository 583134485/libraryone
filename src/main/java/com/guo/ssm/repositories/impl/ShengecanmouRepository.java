package com.guo.ssm.repositories.impl;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.guo.ssm.model.ExcelViewModel;
import com.guo.ssm.model.ShengecanmouModel;
import com.guo.ssm.repositories.Repository;

public class ShengecanmouRepository  implements Repository<ShengecanmouModel>{

	 MongoTemplate mongoTemplate;
		
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<ShengecanmouModel> getAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(ShengecanmouModel.class);
	}

	@Override
	public void saveObject(ShengecanmouModel object) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(object);		
	}

	@Override
	public void saveListOfObject(List<ShengecanmouModel> objects) {
		// TODO Auto-generated method stub
		//mongoTemplate.insert(objects, ShengecanmouModel.class);
		mongoTemplate.insertAll(objects);
		
	}

	@Override
	public ShengecanmouModel findonebyname(String filename) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
