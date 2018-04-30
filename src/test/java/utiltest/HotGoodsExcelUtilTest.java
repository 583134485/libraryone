package utiltest;

import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.guo.ssm.model.NewHotGoodsModel;
import com.guo.ssm.util.HotGoodsExcelUtil;
import com.guo.ssm.util.HotGoodsExcelUtilNew;

public class HotGoodsExcelUtilTest {
	
	Logger logger=Logger.getLogger(Class.class);
	
HotGoodsExcelUtil excelUtil =new HotGoodsExcelUtil();
HotGoodsExcelUtilNew newexcelutil = new HotGoodsExcelUtilNew();
	
/*	@Test
	public  void testexcelutil() throws Exception{
		logger.info("dd");
		Map map=excelUtil.getexcel("F:\\excel\\hot2.xlsx");
		logger.info(map.toString());
		
	}*/
	
	@Test
	public void testnewutil() throws Exception{
		NewHotGoodsModel a =newexcelutil.GetOneExcel("F:\\excel\\0.xlsx");
		//NewHotGoodsModel b =newexcelutil.GetOneExcel("F:\\excel\\1.xlsx");
		//NewHotGoodsModel c =newexcelutil.GetOneExcel("F:\\excel\\2.xlsx");
		logger.info(a);
		//logger.info(b);
		//logger.info(c);
		
	}

}
