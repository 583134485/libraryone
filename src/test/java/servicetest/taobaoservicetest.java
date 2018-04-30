package servicetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.guo.ssm.dao.NewGoodsModelDao;
import com.guo.ssm.dto.JsonDemoDto;
import com.guo.ssm.model.NewGoodsModel;
import com.guo.ssm.model.NewHotGoodsModel;
import com.guo.ssm.model.Taobaoshop;
import com.guo.ssm.service.TaobaoshopService;
import com.guo.ssm.util.DtoToModelUtil;
import com.guo.ssm.util.HotGoodsExcelUtilNew;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:spring/*.xml")
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)  
//@Transactional
public class taobaoservicetest {
	Logger log=Logger.getLogger(Class.class);
	
	
	@Autowired
	TaobaoshopService taobaoshopService;
	

	
	
	
	@Test
	public void tesdatacount(){
		Map <String,String> map=new HashMap<String,String>();
		map=taobaoshopService.CountAll(10000);
		log.info(map);
		
	}
	
	@Test 
	public void testmakenewshop(){
		taobaoshopService.MakeNewShop();
	}
	
	@Test
	public void testfindbyname() throws Exception{
		long a=System.currentTimeMillis();
		List<Taobaoshop> taobaoshops=taobaoshopService.FindShopByName("zengliu旗舰店");
		long b=System.currentTimeMillis();
		log.info("共话费"+(b-a));
	}
	
	@Test
	public void jsondemodto() throws Exception{
		long a=System.currentTimeMillis();
		List<JsonDemoDto> jsonDemoDtos=taobaoshopService.ShowTreeMap("zengliu旗舰店");
		/*for(JsonDemoDto jsonDemoDto:jsonDemoDtos){
			log.info(jsonDemoDto);
		}*/
	    long b=System.currentTimeMillis();
		log.info("大小size"+jsonDemoDtos.size()+"test费时"+(b-a)+"ms");
	}
	
	@Test
	public void testgoodshow() throws Exception{
		Map map=new HashMap<String, List>();
		map=taobaoshopService.ShowHotGoods("F:\\excel\\hot2.xlsx");
		log.info(map);
	}
	

}
