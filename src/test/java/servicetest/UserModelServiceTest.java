package servicetest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.shiro.service.UserModelService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:spring/*.xml")
public class UserModelServiceTest {
	Logger logger=Logger.getLogger(getClass());
	
	@Autowired
	UserModelService userservice;
	
	@Test
	public void findbyname(){
		logger.info(userservice.findByUsername("1"));
	}

}
