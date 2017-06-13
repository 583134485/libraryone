package daotest;

import java.util.List;




import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.dao.UserDao;
import com.guo.ssm.model.User;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class userdaotest {
	@Autowired
	 private UserDao userdao;
	

	
	
	@Test
	public void testfindAlluser() {
		System.out.println("start");
		 List <User> user=userdao.findAllUser();
		 System.out.println("1");
		 if(user==null){
			 System.out.println("null");
		 }
		 else{
			 
		 for(User a :user){
			 System.out.println(a); 
		 }
		 
		 }		 
	}
	
	@Test
	public void addUser(){
		User user=new User();
		user.setUsername("渣渣");
		user.setUserpassword("fff");
		user.setUserclass("class1");
		userdao.addUser(user);
		List <User> b=userdao.findAllUser();
		 for(User a :b){
			 System.out.println(a); }

	}
	@Test
	 public void updateUser(){
		User user =new User();
		user.setUserid(2);
		user.setUsername("提米");
		user.setUserpassword("ddd");
		user.setUserclass("class2");
		System.out.println("1");
		userdao.updateUser(user);
	List <User> b=userdao.findAllUser();
		 for(User a :b){
			 System.out.println(a); 
	}
	}
	
/*	@Test 
	 public void  deleteUser() throws Exception{
		userdao.deleteUser(4);
	List <User> b=userdao.findAllUser();
	 for(User a :b){
		 System.out.println(a); 
}
}*/
	
	@Test
	public void finduserbyid(){
		
		User user=userdao.findUserById(1);
		System.out.println(user);
		
	}
	
}
