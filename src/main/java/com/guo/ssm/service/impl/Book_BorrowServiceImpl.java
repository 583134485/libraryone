package com.guo.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guo.ssm.dao.Book_BorrowDao;
import com.guo.ssm.model.Book_Borrow;
import com.guo.ssm.service.Book_BorrowService;
@Service
public class Book_BorrowServiceImpl implements Book_BorrowService {
	
	@Autowired
	Book_BorrowDao bbdao;

	@Override
	public List<Book_Borrow> findAllBoBor() {
		List<Book_Borrow> bblist=bbdao.findAllBoBor();
		return bblist;
	}

	@Override
	public void addBoBor(Book_Borrow bobor) {
		bbdao.addBoBor(bobor);

	}

	@Override
	public void deleteBoBor(long borrowid) {
		bbdao.deleteBoBor(borrowid);

	}

	@Override
	public void updateBoBor(Book_Borrow bobor) {
		bbdao.updateBoBor(bobor);
		

	}
	@Override
	public Book_Borrow findBorrowById(long borrowid){
		Book_Borrow borrow=bbdao.findBorrowById(borrowid);
		return borrow;
	}

}
