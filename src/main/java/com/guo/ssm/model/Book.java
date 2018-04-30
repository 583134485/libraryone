package com.guo.ssm.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Book {
	

private long bookid;

@NotEmpty
@Size(min=4, max=10)
private String bookname;
public long getBookid() {
	return bookid;
}
public void setBookid(long bookid) {
	this.bookid = bookid;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
@Override
public String toString() {
	return "Book [bookid=" + bookid
			+ ", bookname=" + bookname 
			+ "]";
}

}
