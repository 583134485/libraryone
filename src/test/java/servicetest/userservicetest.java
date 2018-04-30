package servicetest;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.model.User;
import com.guo.ssm.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-redis.xml","classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class userservicetest {
	Logger log=Logger.getLogger(Class.class);
	
	
	@Autowired
	UserService userservice;
	
	@Test
	public void finusrusrbyname(){
		User user=userservice.UserLogin("s123", "123");
		if(user==null){
			log.info("nnnnnnnnnnnnnnnnnnnnnnnnn");
		}
		log.info(user);
	}
	@Test
	public void findalluser(){
		
		List<User> user=userservice.fingAllUser();
		for (User users : user) {
			System.out.println(users);
		}
	}
	
	@Test 
	public void adduser(){
		User user=new User();
		user.setUsername("渣渣");
		user.setUserpassword("fff");
		user.setUserclass("class1");
	log.info("1");
		userservice.addUser(user);
		log.info("2");
		List <User> b=userservice.fingAllUser();
		 for(User a :b){
			 System.out.println(a); }
	}
	}


