

package daotest;



import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.dao.UserModelDao;
import com.guo.ssm.model.UserModel;
import com.guo.ssm.model.UserRoleModel;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午2:33:30
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserModelDaoTest {
	
	Logger logger=Logger.getLogger(Class.class);
 @Autowired
 UserModelDao usermodeldao;
	 
	@Test
	public void findbyid(){
		 logger.info(usermodeldao.FindById(1l));
	}
	
	@Test
	public void findbyname(){
		logger.info(usermodeldao.FindByName("1"));
	}
	@Test
	public void createuser(){
		UserModel userModel=new UserModel();
		userModel.setSalt("2");
		userModel.setUsername("test1");
		userModel.setUserpassword("testpass");
		usermodeldao.createUser(userModel);
	}
	
	@Test
	public void adduserrole(){

		//usermodeldao.addUserRole(1l,1l);
	}
	
	@Test
	public void findrole(){
		Set<String> set=usermodeldao.findRoles("1");
		logger.info(set);
	}
	@Test
	public void findpermision(){
		Set<String> set=usermodeldao.findPermissions("1");
		logger.info(set);
	}
	
}
