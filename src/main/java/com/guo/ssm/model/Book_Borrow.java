package com.guo.ssm.model;


import java.util.Date;


import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


//序列化我也不知到距地啥用
public class Book_Borrow {
    private long borrowid;

    @NotEmpty(message = "not nul;44")
    private String bookid;

    @NotEmpty(message = "not null userid")
    private String userid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date borrowdate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future
    @NotNull
    private Date returndate;

    @NotEmpty(message = "not null 99")
    private String borrowstate;

    public long getBorrowid() {
        return borrowid;
    }


    public void setBorrowid(long borrowid) {
        this.borrowid = borrowid;
    }


    public String getBookid() {
        return bookid;
    }


    public void setBookid(String bookid) {
        this.bookid = bookid;
    }


    public String getUserid() {
        return userid;
    }


    public void setUserid(String userid) {
        this.userid = userid;
    }


    public Date getBorrowdate() {
        return borrowdate;
    }


    public void setBorrowdate(Date borrowdate) {
        this.borrowdate = borrowdate;
    }


    public Date getReturndate() {
        return returndate;
    }


    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }


    public String getBorrowstate() {
        return borrowstate;
    }


    public void setBorrowstate(String borrowstate) {
        this.borrowstate = borrowstate;
    }


    @Override
    public String toString() {
        return "Book_Borrow [borrowid=" + borrowid + ", bookid=" + bookid + ", useris=" + userid + ", borrowdate=" + borrowdate
                + ", returndate=" + returndate + ", borrowstate=" + borrowstate + "]";
    }


}
