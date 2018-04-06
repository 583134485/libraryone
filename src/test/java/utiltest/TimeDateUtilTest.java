package utiltest;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;


import com.guo.ssm.util.TimeDateUtil;

public class TimeDateUtilTest {
	Logger logger=Logger.getLogger(Class.class);
	@Test
	public void testone() throws Exception{
		TimeDateUtil timeDateUtil=new TimeDateUtil();
		List<String> aList=timeDateUtil.changeStringTimeToListStringTime("2017-7-20", "2017-7-30");
		logger.info(aList);
	}

}
