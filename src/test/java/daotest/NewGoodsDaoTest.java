package daotest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.stat.TableStat.Mode;
import com.alibaba.druid.support.logging.Log;
import com.guo.ssm.dao.NewGoodsModelDao;
import com.guo.ssm.model.NewGoodsModel;

@RunWith(SpringJUnit4ClassRunner.class)
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)  
//@Transactional
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class NewGoodsDaoTest {
	Logger log=Logger.getLogger(Class.class);
	@Autowired
	private NewGoodsModelDao newGoodsModelDao;
	
   @Test
   public void findall(){
	   log.info("33");
	   List<NewGoodsModel> newGoodsModelDaos=newGoodsModelDao.findall();
	   log.info("1");
	   log.info(newGoodsModelDaos.toString());	   	   
   }
   @Test
   public void insertByBatch(){
	   NewGoodsModel newGoodsModel=new NewGoodsModel();
	   newGoodsModel.setId("2");
	   newGoodsModel.setDatatime("2");
	   newGoodsModel.setStyleNumber("2");
	   List<NewGoodsModel>newGoodsModels=new ArrayList<NewGoodsModel>();
	   newGoodsModels.add(newGoodsModel);
	   newGoodsModelDao.insertByBatch(newGoodsModels);
	   log.info("11");
   }
	
	

}
