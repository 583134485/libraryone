package shedulerTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.quartz.QuartzUtil;
import com.guo.ssm.quartz.QuartzUtilImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-quartz.xml")
public class QuartzUtilTest {

	@Autowired
    private 	QuartzUtil quartzUtil;
	
	@Test
	public void testquartzutil() throws SchedulerException, InterruptedException{
		quartzUtil.startAllJobs();
		Thread.sleep(19000);
		quartzUtil.shutdownAllJobs();
		/*QuartzUtilImpl quartzUtilImpl=new QuartzUtilImpl();
		quartzUtilImpl.startAllJobs();
		Thread.sleep(3000);
		quartzUtilImpl.shutdownAllJobs();*/
	}
}
