package com.guo.ssm.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.repository.config.RepositoryBeanDefinitionRegistrarSupport;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.guo.ssm.model.ExcelModel;
import com.guo.ssm.model.ExcelViewModel;
import com.guo.ssm.repositories.Repository;
import com.guo.ssm.repositories.impl.ExcelRepository;
import com.guo.ssm.service.IExcelService;
import com.guo.ssm.util.ExcelUtil;
import com.guo.ssm.util.FileDaoUtil;
import com.mongodb.MongoExecutionTimeoutException;

@Service
public class ExcelService implements IExcelService{

	private  static final Logger log=LoggerFactory.getLogger(ExcelService.class);
	
	@Autowired
	Repository<ExcelModel> repository;
	
	@Override
	public Map<String, List<String>> ParseSingleExcelToJson(MultipartFile file) {
		
		ExcelModel findresult=new ExcelModel();
		try {
			 findresult=repository.findonebyname(file.getOriginalFilename().toString());
				if(findresult!=null) {
					log.info("已存在 mongo 持久 ");
					return findresult.getData();
				}
				else {
					log.info("不存在 对应的 mongo excel model");
				}	
		}
		catch (Exception e) {
			// TODO: handle exception
		}

		
		
		
		String filepath=FileDaoUtil.UploadFile(file);
		log.info("filepath saved as "+filepath);
		Map<String, List<String>> result=null;
		try {
			result = ExcelUtil.ParseExcelToExcelModel(filepath);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		持久化
		if(result!=null) {
			//ExcelRepository repository=new ExcelRepository();
			ExcelModel excelModel=new ExcelModel();
			excelModel.setFilename(file.getOriginalFilename());
			excelModel.setData(result);
			//log.info("excelmodel"+excelModel.toString());
	//excelRepository.saveObject(excelModel);
/*	        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
	                "classpath:/spring/spring-mongo.xml");
	 
	        Repository repository = context.getBean(ExcelRepository.class);*/
			
			try {
				 findresult=repository.findonebyname(file.getOriginalFilename().toString());
				if(findresult==null) {
					repository.saveObject(excelModel);
				}
				else {
					log.info("已存在 excel model");
				}
			}
			catch (Exception e) {
				// TODO: handle exception
				log.info("mongodb 操作失败");
				e.printStackTrace();
			
			}
			
		}

		
		return result;
	}

}
