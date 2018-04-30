package com.guo.ssm.service;

import java.util.List;

import com.guo.ssm.model.Book_Borrow;

public interface Book_BorrowService {
	List <Book_Borrow> findAllBoBor();
	void addBoBor (Book_Borrow bobor);
	void deleteBoBor(long borrowid);
	void updateBoBor (Book_Borrow bobor);
	Book_Borrow findBorrowById(long borrowid);
	

}
