package com.guo.ssm.service.impl;

import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guo.ssm.controller.exception.ServiceException;
import com.guo.ssm.dao.BookDao;
import com.guo.ssm.model.Book;
import com.guo.ssm.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDao bookdao;

	@Override
	public List<Book> findAllBook() {
		List <Book> book=bookdao.findAllBook();
		return book;
	}

	
	@Override
	public void addBook(Book book) {
		bookdao.addBook(book);

	}

	@Override
	public void deleteBook(long bookid) {
		bookdao.deleteBook(bookid);

	}
    
	@Transactional
	@Override
	public void updateBook(Book book) {
		if(book.getBookname().equals("6666")){
		 throw	 new ServiceException("6666 is not good");
		}
		
		else{
			bookdao.updateBook(book);
		}
		

	}
	@Override
	public Book findBookById(long bookid){
		Book book =bookdao.findBookById(bookid);
		return book;
	}

}
