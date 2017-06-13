package daotest;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.dao.Book_BorrowDao;
import com.guo.ssm.model.Book_Borrow;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class bookborrowdaotest {
	Logger log=Logger.getLogger(Class.class);
	@Autowired
	Book_BorrowDao bobor;
	@Test
	public void findallbobor(){
		log.info("1");
		List <Book_Borrow> bb=bobor.findAllBoBor();
		log.info("find");
		for (Book_Borrow borrow:bb){
			/*log.info(borrow);*/
			System.out.println(borrow);
			
		}
	

	}
	@Test
	public void addbobor(){
	Book_Borrow bb=new Book_Borrow();
		bb.setBookid("1");
		bb.setUserid("1");
		bb.setBorrowstate("2");
		Date   now   =   new   Date(System.currentTimeMillis());
		bb.setBorrowdate(now);
		bb.setReturndate(now);
		log.info("1");
		bobor.addBoBor(bb);
		log.info("2");
		
	}
	@Test
	public void updatebobor(){
		Book_Borrow bb=new Book_Borrow();
		bb.setBorrowid(2);
		bb.setBookid("1");
		bb.setUserid("1");
		bb.setBorrowstate("999");
		Date   now   =   new   Date(System.currentTimeMillis());
		bb.setBorrowdate(now);
		bb.setReturndate(now);
		bobor.updateBoBor(bb);
	}
	
	@Test
	public void deletebobor(){
		bobor.deleteBoBor(4);
	}

}
