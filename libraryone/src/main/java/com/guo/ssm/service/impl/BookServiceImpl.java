package com.guo.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public void updateBook(Book book) {
		bookdao.updateBook(book);

	}
	@Override
	public Book findBookById(long bookid){
		Book book =bookdao.findBookById(bookid);
		return book;
	}

}
