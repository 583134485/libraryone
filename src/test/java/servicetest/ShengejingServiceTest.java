package servicetest;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.dto.ShengejingDto;
import com.guo.ssm.service.ShengejingService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( "classpath:spring/*.xml")
//@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)  
//@Transactional
public class ShengejingServiceTest {
	Logger logger =Logger.getLogger(Class.class);
	@Autowired 
	ShengejingService shengejingService;
	
	 @Test
	 public void findlongdaytest() throws Exception{
		  ShengejingDto shengejingDto=shengejingService.findLongDayData("2017-08-01", "2017-09-03","七格格旗舰店");
		  logger.info(shengejingDto);
	 }
	 
	 @Test
	 public void findlongdetailtes() throws Exception{
		 List<ShengejingDto> shengejingDtos=shengejingService.findDetailLongDayData("2017-08-28", "2017-09-03","七格格旗舰店");
		 for(ShengejingDto shengejingDto:shengejingDtos){
			 logger.info(shengejingDto);
		 }
	 }

}
