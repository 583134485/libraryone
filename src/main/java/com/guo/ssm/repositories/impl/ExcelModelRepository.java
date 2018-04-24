package com.guo.ssm.repositories.impl;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.guo.ssm.model.ExcelViewModel;
import com.guo.ssm.repositories.Repository;

public class ExcelModelRepository implements Repository<ExcelViewModel> {

	 MongoTemplate mongoTemplate;
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<ExcelViewModel> getAll() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(ExcelViewModel.class);
	}

	@Override
	public void saveObject(ExcelViewModel object) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(object);
		
	}

}
