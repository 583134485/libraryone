package daotest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.controller.testController;
import com.guo.ssm.dao.ShengejingModelDao;
import com.guo.ssm.dto.ShengejingDto;
import com.guo.ssm.model.ShengejingModel;
import com.guo.ssm.util.ShengejingModelToDtoUtil;
import com.guo.ssm.util.TimeDateUtil;
import com.mysql.fabric.xmlrpc.base.Data;

@RunWith(SpringJUnit4ClassRunner.class)
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)  
//@Transactional
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ShengejingModelDaoTest {
	
	Logger logger=Logger.getLogger(Class.class);
     
	@Autowired
	private ShengejingModelDao shengejingmodeldao;
	
	
	@Test
	public void findadll() throws Exception{
		logger.info("1");
		List<ShengejingModel> shengejingModels=shengejingmodeldao.findall();
		logger.info(shengejingModels);
	}
	
	@Test
	public void findbymodel() throws Exception{
		ShengejingModel  shengejingModel=new ShengejingModel();
		shengejingModel.setName("suibian");
		List<ShengejingModel> shengejingModels=shengejingmodeldao.findByModel(shengejingModel);
		logger.info(shengejingModels);
		
		
	}
	
	@Test
	public void findallbymodel()  throws Exception{
		ShengejingModel  shengejingModel=new ShengejingModel();
		//构造Timestamp方法一
         Timestamp t1=Timestamp.valueOf("2017-08-26 00:00:00");
		logger.info(t1.toString());
		shengejingModel.setRecordtime(t1);
		logger.info(shengejingModel.getRecordtime());
		List<ShengejingModel> shengejingModels=shengejingmodeldao.findallByModel(shengejingModel);
		for(ShengejingModel shengejingModel2:shengejingModels){
			logger.info(shengejingModel2.getRecordtime());
		}
		logger.info(shengejingModels.size());
	}
	
	@Test
	public void findallbymodel2()  throws Exception{
		ShengejingModel  shengejingModel=new ShengejingModel();
		String ss = "2017-8-26 00:00:00";
		//构造Timestamp方法二
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
			//string to date
			java.util.Date date = sdf.parse(ss);
			//date to simpledateformate
		 //   date=sdf.parse(sdf.format(date)); 
			Timestamp t1 = new Timestamp(date.getTime());
		logger.info(t1.toString());
		shengejingModel.setRecordtime(t1);
		shengejingModel.setShop("七格格旗舰店");
		logger.info(shengejingModel.getRecordtime());
		List<ShengejingModel> shengejingModels=shengejingmodeldao.findallByModel(shengejingModel);
		for(ShengejingModel shengejingModel2:shengejingModels){
			logger.info(shengejingModel2.getRecordtime());
		}
		logger.info(shengejingModels.size());
	}
	

	
	
	@Test
	public void testlongday2() throws Exception{
		TimeDateUtil timeDateUtil=new TimeDateUtil();
		Timestamp begin=timeDateUtil.StringToTimestamp("2017-8-26");
		Timestamp end =timeDateUtil.StringToTimestamp("2017-8-29");
		List<ShengejingModel> shengejingModels=shengejingmodeldao.findLongDayModel(begin, end, "七格格旗舰店");
		logger.info(shengejingModels.size());
		ShengejingModelToDtoUtil shengejingModelToDtoUtil=new ShengejingModelToDtoUtil();
		ShengejingDto shengejingDto=shengejingModelToDtoUtil.changeLongDayModeltoDto(shengejingModels);
		logger.info(shengejingDto);
	}

}
