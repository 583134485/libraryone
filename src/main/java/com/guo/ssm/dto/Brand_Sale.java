package com.guo.ssm.dto;

import com.guo.ssm.model.Taobaoshop;

public class Brand_Sale {
	
	public String totalSale;
	public Brand_Sale(String brand, String totalSale) {
		super();
		this.totalSale = totalSale;
		this.brand = brand;
	}
	public String brand;
	public Brand_Sale(Taobaoshop taobaoshop) {
		this.totalSale=taobaoshop.getTotalSale();
		this.brand=taobaoshop.getBrand();
	}

	@Override
	public String toString() {
		return "Brand_Sale [totalSale=" + totalSale + ", brand=" + brand + "]";
	}
	public String getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(String totalSale) {
		this.totalSale = totalSale;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	

}
