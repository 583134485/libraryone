package controllertest;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.ModelMap;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.guo.ssm.controller.AppController;
import com.guo.ssm.model.Book_Borrow;
import com.guo.ssm.model.User;
import com.guo.ssm.service.Book_BorrowService;
import com.guo.ssm.service.UserService;

public class controllertest {
	
	@Spy
	ModelMap model;
	@Spy
	List<User> userlist = new ArrayList<User>();
	@Spy
	List <Book_Borrow> borrowlist=new ArrayList<Book_Borrow>();
	@Mock
	UserService service;
	@Mock
	Book_BorrowService borrowservice;
	
	@InjectMocks
	AppController appController;
	
	@BeforeClass
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		userlist=getUserList();	
	}
	public  List <User> getUserList(){
		User u1=new User();
	u1.setUserclass("dsf");
	u1.setUserid(1);
	u1.setUsername("sdfsa");
	u1.setUserpassword("sfds");
	User u2=new User();
	u2.setUserclass("dsf");
	u2.setUserid(1);
	u2.setUsername("sdfsa");
	u2.setUserpassword("sfds");
		userlist.add(u1);
		userlist.add(u2);
		
		return userlist;
	}
	@Test 
	public  void testlist(){
		System.out.println(userlist);
	when(service.fingAllUser()).thenReturn(userlist);
	System.out.println(1);
	Assert.assertEquals(appController.listUser(model), "userlist");
	System.out.println(2);
	Assert.assertEquals(model.get("users"), userlist);
	System.out.println(3);
	verify(service, atLeastOnce()).fingAllUser();	
	}
	
/*	@Test
	public void  testlistborrow(){
		when(borrowservice.findAllBoBor()).thenReturn(borrowlist);
		Assert.assertEquals(appController.listBookBor(model), "bookborrowlist");
		verify(borrowservice,atLeastOnce()).findAllBoBor();
		
		
		
	}*/
	
	
	@Test
	public void testnewuser(){
		Assert.assertEquals(appController.newuser(model), "useredit");
		Assert.assertFalse((Boolean)model.get("edit"));
		
	}
	
	
}
