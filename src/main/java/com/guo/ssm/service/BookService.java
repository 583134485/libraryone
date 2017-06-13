package com.guo.ssm.service;

import java.util.List;

import com.guo.ssm.model.Book;

public interface BookService {
	
	List <Book> findAllBook();
	
	void addBook(Book book);
	
	void deleteBook(long bookid);
	
	void updateBook(Book book);
	
	Book findBookById(long bookid);

	
	
	

}
