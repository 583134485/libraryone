package com.guo.ssm.controller;

import java.util.List;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.context.MessageSource;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
/*import org.springframework.validation.FieldError;*/
/*import org.springframework.web.bind.annotation.ModelAttribute;*/
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*import org.springframework.web.bind.annotation.SessionAttributes;*/

import com.guo.ssm.model.Book;
import com.guo.ssm.model.Book_Borrow;
import com.guo.ssm.model.User;
import com.guo.ssm.service.BookService;
import com.guo.ssm.service.Book_BorrowService;
import com.guo.ssm.service.UserService;

@Controller
@RequestMapping("/")
public class AppController {
	
	
	@Autowired
	UserService userservice;
	@Autowired
	BookService bookservice;
	@Autowired
	Book_BorrowService borrowservice;
	
	@RequestMapping(value={"/"},method=RequestMethod.GET)
	public String mainlist(ModelMap model){
		String m="主页";
		model.addAttribute("success",m);
		return  "success";
		
	}
	
//show user
	@RequestMapping(value={"userlist"} ,method=RequestMethod.GET)
	 public String listUser(ModelMap  model){
		List <User> users=userservice.fingAllUser();
		model.addAttribute("users",users);
		return "userlist" ;
		
	}
	//show book
	@RequestMapping(value={"/booklist"},method=RequestMethod.GET)
	public String listBook(ModelMap model){
		List<Book> books=bookservice.findAllBook();
		model.addAttribute("books",books);
		return "booklist";
		
	}
	
	
	//show bookborrow
	@RequestMapping(value={"/borrowlist"},method=RequestMethod.GET)
	public String listborrow(ModelMap model){
		List <Book_Borrow> borrow=borrowservice.findAllBoBor();
		model.addAttribute("borrows",borrow);
		return "borrowlist";
	}
	
/*	@RequestMapping(value={"/bookborrowlist"},method=RequestMethod.GET)
	public String listBookBor(ModelMap model){
		List <Book_Borrow> bookbor=borrowservice.findAllBoBor();
		model.addAttribute("book_borrow",bookbor);
		return "bookborrowlist";
		
	}*/
	//useredit
	@RequestMapping(value={"/edit-user-{userid}"},method=RequestMethod.GET)
	public String editUser(@PathVariable long userid,ModelMap model )
	{
		User user=userservice.findUserById(userid);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		
		return "useredit";
	}
	//get useredit
	@RequestMapping(value={"/edit-book-{bookid}"},method=RequestMethod.GET)
	public String editBook(@PathVariable long bookid,ModelMap model )
	{
		Book book=bookservice.findBookById(bookid);
		model.addAttribute("book", book);
		model.addAttribute("edit", true);
		
		return "bookedit";
	}
	//get  Borrow  edit
	@RequestMapping(value={"/edit-borrow-{borrowid}"},method=RequestMethod.GET)
	public String editborrow(@PathVariable long borrowid,ModelMap model )
	{
		Book_Borrow book_borrow=borrowservice.findBorrowById(borrowid);
		model.addAttribute("borrow", book_borrow);
		model.addAttribute("edit", true);
		
		return "borrowedit";
	}
	
	/*@RequestMapping(value={"/edit-bookborrow-{borrowid}"},method=RequestMethod.GET)
	public String editborrow(@PathVariable long borrowid,ModelMap model )
	{
		Book_Borrow book_borrow=borrowservice.findBorrowById(borrowid);
		model.addAttribute("book_borrow", book_borrow);
		model.addAttribute("edit", true);
		
		return "bookborrowedit";
	}*/
	
	
	//post user edit
	@RequestMapping(value={"/edit-user-{userid}"},method=RequestMethod.POST)
	//关于post submit no idea @valid and bindingresult must ?
	public String updateuser(@Valid  User user,  BindingResult result,ModelMap model){
		if(result.hasErrors()){
			return "useredit";
		}
		userservice.updateUser(user);
		model.addAttribute("success", "User " + 
				user.getUsername() + 
				"password: "+ 
				user.getUserpassword()+
				"class:"+
				user.getUserclass()+
				" 更新 成功");
				return "success";
			}		
	//post book edit
	@RequestMapping(value={"/edit-book-{bookid}"},method=RequestMethod.POST)
	//关于post submit no idea @valid and bindingresult must ?
	public String updatebook(@Valid  Book book,  BindingResult result,ModelMap model){
		
		if(result.hasErrors()){
		
			return "bookedit";
			
		}
		bookservice.updateBook(book);
		model.addAttribute("success", "Book " + 
				book.getBookid() +
				book.getBookname()+
				" 更新 成功");
				return "success";
			}
	//post borrow edit
	@RequestMapping(value={"/edit-borrow-{borrowid}"},method=RequestMethod.POST)
	public String updateborrow(@Valid Book_Borrow book_borrow,BindingResult result,ModelMap model){
		if(result.hasErrors()){
			model.addAttribute("borrow",book_borrow);
			return "borrowedit";
		}
		borrowservice.updateBoBor(book_borrow);
		model.addAttribute("success", "Borrow " + 
				" 更新 成功");
				return "success";
			}
	
	
/*	@RequestMapping(value={"/edit-bookborrow-{borrowid}"},method=RequestMethod.POST)
	public String updateborrow(@Valid Book_Borrow book_borrow,BindingResult result,ModelMap model){
		if(result.hasErrors()){
		
			return "bookborrowedit";
		}
		borrowservice.updateBoBor(book_borrow);
		model.addAttribute("success", "Borrow " + 
				" 更新 成功");
				return "success";
			}*/
	//new user
	@RequestMapping(value={"/newuser"},method=RequestMethod.GET)
	public String newuser(ModelMap model)
	{
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "useredit";
	}
	
	//new book
	@RequestMapping(value={"/newbook"},method=RequestMethod.GET)
	public String newbook(ModelMap model)
	{
		Book book=new Book();
		model.addAttribute("book", book);
		model.addAttribute("edit", false);
		return "bookedit";
	}
	//new  borrow 
	@RequestMapping(value={"/newborrow"},method=RequestMethod.GET)
	public String newborrow(ModelMap model)
	{
	 Book_Borrow borrow=new Book_Borrow();
		model.addAttribute("borrow", borrow);
		model.addAttribute("edit", false);
		return "borrowedit";
	}
	
	
	/*@RequestMapping(value={"/newborrow"},method=RequestMethod.GET)
	public String newborrow(ModelMap model)
	{
	 Book_Borrow borrow=new Book_Borrow();
		model.addAttribute("book_borrow", borrow);
		model.addAttribute("edit", false);
		return "bookborrowedit";
	}*/
	
	//post newusr
	@RequestMapping(value={"/newuser"},method=RequestMethod.POST)
	public String addbook(@Valid User user,  BindingResult result, ModelMap model)
	{
		if(result.hasErrors()){
			return "useredit";
		}
		userservice.addUser(user);
		model.addAttribute("success", "User " + 
		user.getUsername() + 
		"password: "+ 
		user.getUserpassword()+
		"class:"+
		user.getUserclass()+
		" registered successfully");
		return "success";
	}

	//post new book
	
	@RequestMapping(value={"/newbook"},method=RequestMethod.POST)
	public String adduser(@Valid Book book,  BindingResult result, ModelMap model)
	{
		if(result.hasErrors()){
			return "bookedit";
		}
		bookservice.addBook(book);
		model.addAttribute("success", "Book " + 
		book.getBookid()+
		book.getBookname()+
		" registered successfully");
		return "success";
	}
	//post new borrow
	@RequestMapping(value={"/newborrow"},method=RequestMethod.POST)
	public String addborrow(@Valid Book_Borrow book_borrow,  BindingResult result, ModelMap model)
	{
		if(result.hasErrors()){
			return "borrowedit";
		}
		borrowservice.addBoBor(book_borrow);
		model.addAttribute("success", "Borrow " + 
		" registered successfully");
		return "success";
	}
	/*@RequestMapping(value={"/newborrow"},method=RequestMethod.POST)
	public String addborrow(@Valid Book_Borrow book_borrow,  BindingResult result, ModelMap model)
	{
		if(result.hasErrors()){
			return "bookborrowedit";
		}
		borrowservice.addBoBor(book_borrow);
		model.addAttribute("success", "Borrow " + 
		" registered successfully");
		return "success";
	}*/
	
	//del user
	@RequestMapping(value = { "/delete-user-{userid}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable long userid) {
		userservice.deleteUserById(userid);
		return "redirect:/userlist";
	}
	//del book
	
	@RequestMapping(value = { "/delete-book-{bookid}" }, method = RequestMethod.GET)
	public String deleteBook(@PathVariable long bookid) {
		bookservice.deleteBook(bookid);
		return "redirect:/booklist";
	}
	
	//del Borrow
	@RequestMapping(value = { "/delete-borrow-{borrowid}" }, method = RequestMethod.GET)
	public String deleteBorrow(@PathVariable long borrowid) {
		borrowservice.deleteBoBor(borrowid);
		return "redirect:/borrowlist";
	}
	/*@RequestMapping(value = { "/delete-bookborrow-{borrowid}" }, method = RequestMethod.GET)
	public String deleteBorrow(@PathVariable long borrowid) {
		borrowservice.deleteBoBor(borrowid);
		return "redirect:/bookborrowlist";
	}*/

}
