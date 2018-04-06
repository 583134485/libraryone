package com.guo.ssm.dto;

import java.io.Serializable;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;

import com.guo.ssm.model.Taobaoshop;
//for testing
public class TaoDataForView   implements Serializable/*extends Taobaoshop*/{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String shop;
	@Override
	public String toString() {
		return "TaoDataForView [shop=" + shop + ", URL=" + URL + "]";
	}

	public String URL;

	public TaoDataForView(Taobaoshop taobaoshop) {
		this.shop=taobaoshop.getShop();
		this.URL=taobaoshop.getURL();
	}
	
	
	
	

}
