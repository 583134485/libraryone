package servicetest;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.model.Book_Borrow;
import com.guo.ssm.service.Book_BorrowService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-redis.xml", "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})
public class borrowservicetest {
	
	Logger log=Logger.getLogger(Class.class);
	
	@Autowired
	Book_BorrowService borser;
	@Test
	public void testfindbyid(){
		Book_Borrow borrow=borser.findBorrowById(2);
		log.info(borrow);
	}
	
	@Test
	public void testfindbr(){
		List<Book_Borrow> borrow=borser.findAllBoBor();
		for(Book_Borrow bb:borrow){
			log.info(bb);
		}
	}
	@Test
	public void testupdate(){
		Book_Borrow borrow11=new Book_Borrow();
		Date   now   =   new   Date(System.currentTimeMillis());
		borrow11.setBorrowid(2);
		borrow11.setBookid("100");
		borrow11.setUserid("55");
		borrow11.setBorrowstate("44");
		borrow11.setBorrowdate(now);
		borrow11.setReturndate(now);
		log.info(borrow11);
		borser.updateBoBor(borrow11);
	}
	@Test
	public void testadd(){
		Book_Borrow borrow11=new Book_Borrow();
		Date   now   =   new   Date(System.currentTimeMillis());
	/*	borrow11.setBorrowid(2);*/
		borrow11.setBookid("100");
		borrow11.setUserid("55");
		borrow11.setBorrowstate("44");
		borrow11.setBorrowdate(now);
		borrow11.setReturndate(now);
		log.info(borrow11);
		borser.addBoBor(borrow11);
	}
	
	

}
