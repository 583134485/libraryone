package com.guo.ssm.repositories.impl;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.guo.ssm.model.ExcelModel;
import com.guo.ssm.repositories.Repository;


	public class ExcelRepository implements Repository<ExcelModel> {
		
		 MongoTemplate mongoTemplate;
		
		public void setMongoTemplate(MongoTemplate mongoTemplate) {
			this.mongoTemplate = mongoTemplate;
		}
		
		
		//findbyby name
		@Override
		public ExcelModel findonebyname(String filename) {
			   Query query = new Query();
			Criteria criteria=Criteria.where("filename").is(filename);
			query.addCriteria(criteria);
			return mongoTemplate.findOne(query, ExcelModel.class);
		}
		
		
		@Override
		public List<ExcelModel> getAll() {
			// TODO Auto-generated method stub
			return mongoTemplate.findAll(ExcelModel.class);
		}

		@Override
		public void saveObject(ExcelModel object) {
			// TODO Auto-generated method stub
			mongoTemplate.insert(object);
			
		}

		@Override
		public void saveListOfObject(List<ExcelModel> objects) {
			// TODO Auto-generated method stub
			
		}

}
