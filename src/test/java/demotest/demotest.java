package demotest;

import java.io.File;
import org.json.JSONObject;



import org.apache.log4j.Logger;
import org.junit.Test;


public class demotest {
	Logger log=Logger.getLogger(Class.class);
	
	//获取webapp路径的尝试
	@Test
	public void testurl(){
		
		// String classPath = this.getClass().getClassLoader().getResource("/").getPath();
		String classPath=Class.class.getClass().getResource("/").getPath();
		log.info(classPath.toString());
		//嘿嘿 获取如下：E:\ssm\libraryone-master\libraryone-master
		log.info(System.getProperty("user.dir")+"\\src\\main\\webapp\\static\\img\\");
		log.info(Thread.currentThread().getContextClassLoader().getResource(""));
		log.info(this.getClass().getClassLoader().getResource("").getPath());
		//log.info(this.getClass().getResource(""));
		//log.info("1");
	}
	
	@Test
	public void tetinfo(){
		   log.info("F:\\fileUpload" + File.separator+"in.png" );
		 //  log.info(context.getRealPath(""));
	}

}
