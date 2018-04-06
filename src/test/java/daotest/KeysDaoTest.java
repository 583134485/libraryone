package daotest;

import java.util.List;



import org.apache.log4j.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.dao.KeysDao;
import com.guo.ssm.model.KeysModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class KeysDaoTest {
	Logger log=Logger.getLogger(Class.class);
	
	@Autowired
	 private KeysDao keysDao;
	
	@Test
	public void testfind()throws Exception{
		
		List <KeysModel> keysModels=keysDao.findall();
		log.info(keysModels);
	}
	@Test
	public void findbyname()throws Exception{
		KeysModel keysModel=keysDao.findbyname("t400旗");
		log.info(keysModel);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	}

}
