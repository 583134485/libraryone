package com.guo.ssm.service;

import java.util.List;

import com.guo.ssm.dto.GoodSale3DDto;
import com.guo.ssm.dto.ShengejingDto;

public interface ShengejingService {
	
	//一家店铺的一天数据
	  ShengejingDto findDayOneData(String datetime,String shop);
	  
	  //模糊查询一段时间内的一家店铺查询，因为时间段是模糊表示
	  ShengejingDto findLongDayData(String begin,String end ,String shop);
	  
	  //返回的是一天对的的一个数据 的List
	 List<ShengejingDto> findDetailLongDayData(String begin,String end ,String shop);
	 
	 List<GoodSale3DDto> readAndShowGoodSale3D(String excelpath);
	

}
