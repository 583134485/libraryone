package daotest;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.guo.ssm.dao.BookDao;
import com.guo.ssm.model.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")

public class bookdaotest {
	Logger log=Logger.getLogger(Class.class);
	
	@Autowired
	BookDao bookdao;
	
	@Test
	public void fingAllerbook(){
		log.info("begin");
		List<Book> book=bookdao.findAllBook();
		log.info("find");
		for(Book a:book){
			System.out.println(a);
		}
	}
	@Test
	public void addbook(){
		Book b=new Book();
		b.setBookid(4);
		b.setBookname("西游士大夫");
		bookdao.addBook(b);
		
		List<Book> book=bookdao.findAllBook();
		for(Book a:book){
			System.out.println(a);
		}
	}
	 @Test 
	 public void update(){
		 Book b=new Book();
			b.setBookid(4);
			b.setBookname("西游士大夫3343dfsf");
			bookdao.updateBook(b);
			log.info("ok");
		 
	 }
	/* @Test
	 public void delete(){
		 bookdao.deleteBook(4);
		 log.info("ok");
	 }*/

}
