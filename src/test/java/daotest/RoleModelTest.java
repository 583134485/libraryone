
package daotest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.dao.RoleModelDao;
import com.guo.ssm.model.RoleModel;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午2:57:04
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class RoleModelTest {
	Logger logger=Logger.getLogger(Class.class);
	@Autowired
	RoleModelDao rolemodeldao;
	
	@Test
	public void  createrole(){
		RoleModel role=new RoleModel();
		role.setDescription("22");
		role.setRole("test");
		rolemodeldao.createRole(role);
	}
	
	@Test
	public void addrolepermission(){
		rolemodeldao.addRolePermission(2l, 2l);
	}
	
			

}
