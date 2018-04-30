
package servicetest;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.model.ShengecanmouModel;
import com.guo.ssm.service.ShengecanmouService;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月19日 下午9:47:50
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:spring/*.xml")
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)  
//@Transactional
public class ShengecanmouServiceTest {
	
	Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	ShengecanmouService shengecanmouservice;
	
	@Test
	public void showhotword(){
		List<ShengecanmouModel> shengecanmouModels=shengecanmouservice.showHotWord("views",10);
		for(ShengecanmouModel shengecanmouModel:shengecanmouModels){
			logger.info(shengecanmouModel.toString());
		}
	}
	
	@Test
	public void keywordaverage(){
		List<ShengecanmouModel> shengecanmouModels=shengecanmouservice.showfullgraph("views");
		logger.info(shengecanmouModels);
	}
	@Test
	public void conversion(){
		ShengecanmouModel shengecanmouModel=shengecanmouservice.showconversion("521099668015");
		logger.info(shengecanmouModel);
	}

}
