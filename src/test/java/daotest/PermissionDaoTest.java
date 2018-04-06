

package daotest;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.dao.PermissionModelDao;
import com.guo.ssm.model.PermissionModel;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 下午3:24:03
* @version 1.0 
* @parameter  
* @Description: TODO(用一句话描述该文件做什么) 
* @since  
* @return  */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class PermissionDaoTest {
	Logger logger=Logger.getLogger(Class.class);
	@Autowired
	PermissionModelDao p;
	@Test
	public void createpermisionmodel(){
		PermissionModel model =new PermissionModel();
		model.setDescription("tes");
		model.setPermission("test");
		p.createPermission(model);
		
	}

}
