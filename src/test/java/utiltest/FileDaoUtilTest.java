package utiltest;


import org.apache.log4j.Logger;
import org.junit.Test;

import com.guo.ssm.util.FileDaoUtil;

public class FileDaoUtilTest {
	
	Logger logger=Logger.getLogger(Class.class);
	
	@Test
	public void isexist(){
		FileDaoUtil fileDaoUtil=new FileDaoUtil();
		logger.info(fileDaoUtil.isExistFile("1.jpg"));
		
		
	}

}
