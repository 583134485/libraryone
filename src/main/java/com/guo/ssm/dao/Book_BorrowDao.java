package com.guo.ssm.dao;

import java.util.List;

import com.guo.ssm.model.Book_Borrow;


public interface Book_BorrowDao {
	List <Book_Borrow> findAllBoBor();
	
    void addBoBor(Book_Borrow bobor);
	
	void  updateBoBor(Book_Borrow bobor); 
	
	void deleteBoBor(long borrowid);
	
	Book_Borrow findBorrowById(long borrowid);

}
