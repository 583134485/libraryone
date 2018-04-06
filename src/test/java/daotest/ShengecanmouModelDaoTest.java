package daotest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.guo.ssm.controller.testController;
import com.guo.ssm.dao.ShengecanmouModelDao;
import com.guo.ssm.model.ShengecanmouModel;
import com.guo.ssm.util.TimeDateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)  
//@Transactional
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class ShengecanmouModelDaoTest {

	Logger logger=Logger.getLogger(Class.class);
	
	@Autowired
	private ShengecanmouModelDao shengecanmouModelDao;
	@Test
	public void allplusByKeyword(){
		List<ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.AllPlusByKeyword("views", 100);
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			logger.info(shengecanmouModel.toString());
		}
	}
	
	@Test
	public void allKeywordAverage(){
		
		ShengecanmouModel shengecanmouModel=shengecanmouModelDao.AllKeyWordAverage("views");
		logger.info(shengecanmouModel);
	}
	@Test
	public void findKeyWordAverage(){
		List<ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.findKeyWordAverage("ordergoods", 1);
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			logger.info(shengecanmouModel.toString());
		}
	
	}
	
	@Test
	public  void findConversionByid(){
		List<ShengecanmouModel>shengecanmouModels=shengecanmouModelDao.findConversionById("521099668015");
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			logger.info(shengecanmouModel.toString());
		}
		logger.info(shengecanmouModels.size());
	}
	@Test
	public void findall(){
		List<ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.findall();
		logger.info(shengecanmouModels.size());
	}
	
	@Test
	public void findAllQuarter(){
		List<ShengecanmouModel>shengecanmouModels=shengecanmouModelDao.findAllQuarter("views",15);
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			logger.info(shengecanmouModel.toString());
		}
		logger.info(shengecanmouModels.size());
	}
	@Test
	public void oderandRefun (){
		List<ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.OderAndRefund("521099668015");
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			logger.info(shengecanmouModel);
		}
		logger.info(shengecanmouModels.size());
	}
	@Test
	public void findallbyidandother(){
		List<ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.findallByIdAndOther("521099668015", "views");
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			logger.info(shengecanmouModel);
		}
		logger.info(shengecanmouModels.size());
	}
	@Test
	public void insertbybatch() throws Exception{
		TimeDateUtil timeDateUtil=new TimeDateUtil();
		String a="a";
		String bb="bb";
		java.sql.Date d1=timeDateUtil.StringtoDate("2015-9-2");
		ShengecanmouModel shengecanmouModel=new ShengecanmouModel(d1, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a);
        ShengecanmouModel shengecanmouModel2=new ShengecanmouModel(d1, bb, bb, a, a, bb, bb, bb, bb, bb, bb, a, a, a, a, a, a, bb, bb, a, a, bb, a, bb, bb, bb, a, a, bb, a, bb);
	    List<ShengecanmouModel> shengecanmouModels=new ArrayList<ShengecanmouModel>();
	    shengecanmouModels.add(shengecanmouModel);
	    shengecanmouModels.add(shengecanmouModel2);
	    shengecanmouModelDao.insertByBatch(shengecanmouModels);
	}
	
	//测试重复插入
	@Test
	public void add() throws ParseException{
		TimeDateUtil timeDateUtil=new TimeDateUtil();
		String a="D";
		java.sql.Date d1=timeDateUtil.StringtoDate("2015-9-2");
		ShengecanmouModel shengecanmouModel=new ShengecanmouModel(d1, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a, a);
		shengecanmouModelDao.add(shengecanmouModel);
		logger.info("1");
		shengecanmouModelDao.add(shengecanmouModel);
		logger.info("2");
		
	}
	@Test
	public void testonedayfind() throws ParseException{
		TimeDateUtil timeDateUtil=new TimeDateUtil();
		java.sql.Date d1=timeDateUtil.StringtoDate("2015-9-2");
		List <ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.findOneDayOneGood(d1, "");
		logger.info(shengecanmouModels.size());
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			logger.info(shengecanmouModel);
		}
	}
	
	@Test
	public void testlongdayfind() throws ParseException{
		TimeDateUtil timeDateUtil=new TimeDateUtil();
		java.sql.Date d1=timeDateUtil.StringtoDate("2011-9-0");
		java.sql.Date d2=timeDateUtil.StringtoDate("2015-9-2");
		List<ShengecanmouModel> shengecanmouModels=shengecanmouModelDao.findLongDayGood(d1, d2, "");
		logger.info(shengecanmouModels.size());
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			logger.info(shengecanmouModel);
		}
		
	}
	
	@Test
	public void testcheckid(){
		ShengecanmouModel shengecanmouModel=shengecanmouModelDao.isExistById("bb");
		logger.info(shengecanmouModel);
	}
	
	@Test
	public void tescheckidnew(){
		int c=shengecanmouModelDao.isExistByIdNew("0");
		logger.info(c);
	}
	
}
