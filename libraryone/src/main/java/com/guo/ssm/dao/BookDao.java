package com.guo.ssm.dao;

import java.util.List;

import com.guo.ssm.model.Book;

public interface BookDao {
	List <Book> findAllBook();
	
	 void addBook(Book book);
	 
	 void updateBook(Book book);
	 
	 void deleteBook(long bookid);	
	 
	 Book findBookById(long bookid);

}
