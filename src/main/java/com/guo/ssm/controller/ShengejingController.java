package com.guo.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guo.ssm.dto.GoodSale3DDto;
import com.guo.ssm.dto.ShengejingDto;
import com.guo.ssm.service.ShengejingService;


@Controller
@RequestMapping("/shengejing")
public class ShengejingController {
	Logger logger=Logger.getLogger(Class.class);
	
	@Autowired
	private ShengejingService shengejingService;
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/oneday",method=RequestMethod.GET)
	public String show(){
		return "Shengejing";
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/oneday2",method=RequestMethod.GET)
	public String show2(){
		return "Shengejing2";
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/oneday3",method=RequestMethod.GET)
	public String show3(){
		return "Shengejing3";
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/oneday4",method=RequestMethod.GET)
	public String show3D(){
		return "Shengejing3D";
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/onedayshow",method=RequestMethod.POST)
	@ResponseBody
	public ShengejingDto showdate(HttpServletRequest request,HttpServletResponse response){
		logger.info("detailurl:"+request.getRequestURL());
		String begindate=request.getParameter("begindate");
		String shop=request.getParameter("shop");
		logger.info("接收参数shop"+shop);
		logger.info("接收参数date"+begindate);
		ShengejingDto shengejingDto=shengejingService.findDayOneData(begindate,shop);
		logger.info("return+ size:"+shengejingDto);
		return shengejingDto;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/longdayshow",method=RequestMethod.POST)
	@ResponseBody
	public ShengejingDto showlongdate(HttpServletRequest request,HttpServletResponse response){
		logger.info("detailurl:"+request.getRequestURL());
		String begindate=request.getParameter("begindate");
		String shop=request.getParameter("shop");
		String enddate=request.getParameter("enddate");
		logger.info("接收参数shop"+shop);
		logger.info("接收参数begindate"+begindate);
		logger.info("接收参数enddate"+enddate);
		ShengejingDto shengejingDto=shengejingService.findLongDayData(begindate, enddate, shop);
		logger.info(shengejingDto);
		return shengejingDto;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/longdayshow3D",method=RequestMethod.POST)
	@ResponseBody
	public  List<ShengejingDto> showlongdate3D(HttpServletRequest request,HttpServletResponse response){
		logger.info("url:"+request.getRequestURL());
		String begindate=request.getParameter("begindate");
		String shop=request.getParameter("shop");
		String enddate=request.getParameter("enddate");
		logger.info("接收参数shop"+shop);
		logger.info("接收参数begindate"+begindate);
		logger.info("接收参数enddate"+enddate);
		List <ShengejingDto> shengejingDtos=shengejingService.findDetailLongDayData(begindate, enddate, shop);
		return shengejingDtos;
	}

	@CrossOrigin(origins="*")
	@RequestMapping(value="/goodsale3D",method=RequestMethod.POST)
	@ResponseBody
	public  List<GoodSale3DDto> showdate3D(HttpServletRequest request,HttpServletResponse response){
		logger.info("url:"+request.getRequestURL());
/*		String begindate=request.getParameter("begindate");
		String shop=request.getParameter("shop");
		String enddate=request.getParameter("enddate");
		logger.info("接收参数shop"+shop);
		logger.info("接收参数begindate"+begindate);
		logger.info("接收参数enddate"+enddate);*/
		//String excelpath=request.getParameter("filepath");
		List<GoodSale3DDto> goodSale3DDtos=shengejingService.readAndShowGoodSale3D("D:\\excel\\三位立体图时间对应品类销量.xlsx");
		return goodSale3DDtos;
	}

}
