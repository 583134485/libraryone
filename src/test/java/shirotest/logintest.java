package shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/shiro-beans.xml","classpath:spring/shiro-beans.xml", "classpath:spring-shiro.xml"})
public class logintest {

	
	//登陆测试
	@Test
	public void testlogin(){
	    Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("1","22");
        subject.login(token);
        Assert.assertTrue(subject.isAuthenticated());
	}
}
