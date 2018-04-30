package utiltest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.dao.ShengejingModelDao;
import com.guo.ssm.dto.ShengejingDto;
import com.guo.ssm.model.ShengejingModel;
import com.guo.ssm.service.ShengejingService;
import com.guo.ssm.util.ShengejingDtoCountUtil;
import com.guo.ssm.util.ShengejingModelToDtoUtil;
import com.guo.ssm.util.TimeDateUtil;

@RunWith(SpringJUnit4ClassRunner.class)
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)  
//@Transactional
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class ShengejingModelToDtoUtilTest {
	Logger logger=Logger.getLogger(Class.class);
	
	@Autowired
	ShengejingModelDao shengejingModelDao;
	//后期测试的时候用现成的，前期测试通过后才放心使用
	@Autowired
	ShengejingService shengejingService;
	
	ShengejingModelToDtoUtil ShengejingModelToDtoUtil=new ShengejingModelToDtoUtil();
	
	TimeDateUtil timeDateUtil=new TimeDateUtil();
	
	@Test
	public void testtimeutil() throws ParseException{
		logger.info(timeDateUtil.StringToTimestamp("2018-02-02"));
	}
	
	//得到dto
	@Test
	public void testone()  throws Exception{
		ShengejingModel shengejingModel=new ShengejingModel();
		shengejingModel.setShop("七格格旗舰店");
		Timestamp timestamp=timeDateUtil.StringToTimestamp("2017-8-26");
		shengejingModel.setRecordtime(timestamp);
		List<ShengejingModel> shengejingModels=shengejingModelDao.findallByModel(shengejingModel);
		long start=System.currentTimeMillis();
		logger.info("begin：listsize"+shengejingModels.size());
		ShengejingDto shengejingDto=ShengejingModelToDtoUtil.changeOneDayModeltoDto(shengejingModels);
		long end =System.currentTimeMillis();
		logger.info("end:time:"+(end-start));
		
	}
	
	//dto 累加
	@Test
	public void testplus () throws Exception{
		List<ShengejingDto> shengejingDtos=new ArrayList<ShengejingDto>();
		ShengejingDto shengejingDto=shengejingService.findDayOneData("2017-8-26", "七格格旗舰店");
		ShengejingDto shengejingDto2=shengejingService.findDayOneData("2017-8-27", "七格格旗舰店");
		ShengejingDto shengejingDto3=shengejingService.findDayOneData("2017-8-28", "七格格旗舰店");
		ShengejingDto shengejingDto4=shengejingService.findDayOneData("2017-8-29", "七格格旗舰店");
		ShengejingDto shengejingDto5=shengejingService.findDayOneData("2017-8-30", "七格格旗舰店");
		shengejingDtos.add(shengejingDto);
		shengejingDtos.add(shengejingDto2);
		shengejingDtos.add(shengejingDto3);
		shengejingDtos.add(shengejingDto4);
		shengejingDtos.add(shengejingDto5);
		ShengejingDtoCountUtil shengejingDtoCountUtil=new ShengejingDtoCountUtil();
		ShengejingDto shengejingDto6=shengejingDtoCountUtil.ShengejingDtoPlus(shengejingDtos);
		logger.info(shengejingDto6);
		
	}
	
	

}
