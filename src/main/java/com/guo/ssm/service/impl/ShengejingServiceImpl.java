package com.guo.ssm.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guo.ssm.dao.ShengejingModelDao;
import com.guo.ssm.dto.GoodSale3DDto;
import com.guo.ssm.dto.ShengejingDto;
import com.guo.ssm.model.ShengejingModel;
import com.guo.ssm.service.ShengejingService;
import com.guo.ssm.util.ExcelUtil;
import com.guo.ssm.util.ShengejingDtoCountUtil;
import com.guo.ssm.util.ShengejingModelToDtoUtil;
import com.guo.ssm.util.TimeDateUtil;

@Service
public class ShengejingServiceImpl implements ShengejingService {
	Logger logger=Logger.getLogger(Class.class);
	
	@Autowired
	private  ShengejingModelDao shengejingModelDao;

	//传入参数，一天的数据
	@Override
	public ShengejingDto findDayOneData(String datetime, String shop) {
		
		TimeDateUtil timeDateUtil=new TimeDateUtil();
		ShengejingModelToDtoUtil shengejingModelToDtoUtil=new ShengejingModelToDtoUtil();
		ShengejingModel shengejingModel=new ShengejingModel();
		
		//设置选择的model
		shengejingModel.setShop(shop);
		try {
			shengejingModel.setRecordtime(timeDateUtil.StringToTimestamp(datetime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<ShengejingModel> shengejingModels=shengejingModelDao.findallByModel(shengejingModel);
		logger.info("translate");
		ShengejingDto shengejingDto=shengejingModelToDtoUtil.changeOneDayModeltoDto(shengejingModels);
		return shengejingDto;
	}

	
	//一家店一段时间的数据
	//查一段时间的数据，用简单的daooneday数据，不会太快
	//在dao层新增时间段查询，where语句
	//原本，通过》dto>dto +dto,所以shengejingdtocount 有点多余了
	//其实可以直接>dto ,中间代码重复了
	@Override
	public ShengejingDto findLongDayData(String begin, String end, String shop) {
		ShengejingDtoCountUtil shengejingDtoCountUtil=new ShengejingDtoCountUtil();
		ShengejingModelToDtoUtil shengejingModelToDtoUtil=new ShengejingModelToDtoUtil();
		TimeDateUtil timeDateUtil=new TimeDateUtil();
			Timestamp beginday =new Timestamp(0);
			Timestamp endday=new Timestamp(0);
			try {
				beginday = timeDateUtil.StringToTimestamp(begin);
				endday =timeDateUtil.StringToTimestamp(end);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				 
			//model get
			List<ShengejingModel> shengejingModels=shengejingModelDao.findLongDayModel(beginday, endday, shop);		
		ShengejingDto shengejingDto=shengejingModelToDtoUtil.changeLongDayModeltoDto(shengejingModels);
	
		
		return shengejingDto;
	}


	
	
	/*思路有多个
	 * 最简单的利用findonedate ,在timeutil添加一个time-begin-end=list datetime 方法,但速度肯定不快
	 * 先实现再说
	 * 利用changeStringTimeToListStringTime string 和date老实相互转化，有点多余
	 * */
	@Override
	public List<ShengejingDto> findDetailLongDayData(String begin, String end, String shop) {
		TimeDateUtil timeDateUtil=new TimeDateUtil();
		List<ShengejingDto> shengejingDtos=new ArrayList<ShengejingDto>();
		try {
			List<String> recordtimelist=timeDateUtil.changeStringTimeToListStringTime(begin, end);
			//最蠢的办法遍历一个个,数据量过大坑定慢
			for(String recordtime:recordtimelist){
				shengejingDtos.add(findDayOneData(recordtime, shop));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return shengejingDtos;
	}


	@Override
	public List<GoodSale3DDto> readAndShowGoodSale3D(String excelpath) {
		ExcelUtil excelUtil=new ExcelUtil();
		List<GoodSale3DDto> goodSale3DDtos=new ArrayList<GoodSale3DDto>();
		try {
			goodSale3DDtos=excelUtil.ReadExcelToGoodSaleDto(excelpath);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodSale3DDtos;
	}

}
