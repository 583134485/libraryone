package com.guo.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.LogoutAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.guo.ssm.model.ShengecanmouModel;
import com.guo.ssm.service.ShengecanmouService;
import com.guo.ssm.util.FileDaoUtil;


@Controller
@RequestMapping("/shengecanmou")
public class ShengecanmouController {
	Logger logger=Logger.getLogger(Class.class);
	
	@Autowired
	private ShengecanmouService shengecanmouService;
	
	//这个api 是给别人调用网页
	@RequestMapping(value="/showuploadfile",method=RequestMethod.GET)
	public String showzhuoya(){
		return "ShengecanmouFileUpload";
	}
	
	// upload post file 
	@CrossOrigin(origins="*")
	@RequestMapping(value="/doupload",method=RequestMethod.POST)
	@ResponseBody
	public String FileUpLoad(HttpServletRequest request,HttpServletResponse response, @RequestParam("file") MultipartFile[] files){
	 logger.info("douploadservice");
		/*
		FileDaoUtil fileDaoUtil=new FileDaoUtil();
		String msg=fileDaoUtil.UploadFiles(files);*/
		//返回处理结果
		String msg=shengecanmouService.FileUpload(request, response, files);
		logger.info("msg:"+msg);
		//会返回成功和失败的信息
		return msg;
		//如何在前端显示进度。。。。
	}
	
	
	
	// ruan'jian
	@CrossOrigin(origins = "*")
    @RequestMapping(value = "/simpledownload", method = RequestMethod.GET)
    @ResponseBody
    public  String SimpleFileDownLoad(HttpServletRequest request,HttpServletResponse response) throws Exception {
 /*  FileDaoUtil fileDaoUtil =new FileDaoUtil();
		
   String  msg = fileDaoUtil.FileDownLoad(request, response);*/
		String filename=request.getParameter("filename");
		String msg =shengecanmouService.FileDownLoad(request, response);
        //返回下载成功与否信息
   return msg;
        
    }
	
	@CrossOrigin(origins = "*")
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    @ResponseBody
    public  String FileDownLoad(HttpServletRequest request,HttpServletResponse response) throws Exception {
  logger.info("link");
		String msg =shengecanmouService.DownLoadSearchDataBaseToExcel(request, response);
        //返回下载成功与否信息
   return msg;
        
    }
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/checkid",method=RequestMethod.POST)
	@ResponseBody
	public Boolean CheckId(HttpServletRequest request,HttpServletResponse response){
	   logger.info("checkid");
		//返回处理结果
		Boolean msg=shengecanmouService.CheckID(request);
		//会返回成功和失败的信息
		return msg;
		//如何在前端显示进度。。。。
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/searchfortable",method=RequestMethod.POST)
	@ResponseBody
	public List<ShengecanmouModel> SearchForTable(HttpServletRequest request,HttpServletResponse response){
	   logger.info("searchtable");
		//返回处理结果
		List<ShengecanmouModel>shengecanmouModels=shengecanmouService.searchfortable(request);
		logger.info("size:"+shengecanmouModels.size());
		//会返回成功和失败的信息
		return shengecanmouModels;
		//如何在前端显示进度。。。。
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/showareatable",method=RequestMethod.POST)
	@ResponseBody
	public List<ShengecanmouModel> showarea(HttpServletRequest request,HttpServletResponse response){
	   logger.info("get"+request.getParameter("id")+request.getParameter("word"));
	  List<ShengecanmouModel> shengecanmouModels=shengecanmouService.showLongDayByID(request.getParameter("id"), request.getParameter("word"));
	   return shengecanmouModels;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/showoderrefund",method=RequestMethod.POST)
	@ResponseBody
	public List<ShengecanmouModel> showOderAndRefund(HttpServletRequest request,HttpServletResponse response){
	   logger.info("get"+request.getParameter("id"));
	  List<ShengecanmouModel> shengecanmouModels=shengecanmouService.showOderAndRefun(request.getParameter("id"));
	  logger.info(shengecanmouModels.size()); 
	  return shengecanmouModels;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/showquarter",method=RequestMethod.POST)
	@ResponseBody
	public List<ShengecanmouModel> showQuarter(HttpServletRequest request,HttpServletResponse response){
	  
	  List<ShengecanmouModel> shengecanmouModels=shengecanmouService.showquarter(request.getParameter("keyword"));
	  logger.info(shengecanmouModels.size()); 
	  return shengecanmouModels;
	}
	
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/showconversion",method=RequestMethod.POST)
	@ResponseBody
	public ShengecanmouModel showConversion(HttpServletRequest request,HttpServletResponse response){
	  
	  ShengecanmouModel shengecanmouModel=shengecanmouService.showconversion(request.getParameter("id"));
	  
	  logger.info(shengecanmouModel);
	  return shengecanmouModel;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/showfullgraph",method=RequestMethod.POST)
	@ResponseBody
	public List<ShengecanmouModel> showFullGraph(HttpServletRequest request,HttpServletResponse response){
	  
	  List<ShengecanmouModel> shengecanmouModel=shengecanmouService.showfullgraph( request.getParameter("keyword"));
	  
	  logger.info(shengecanmouModel);
	  return shengecanmouModel;
	}
	
	@CrossOrigin(origins="*")
	@RequestMapping(value="/showHotWord",method=RequestMethod.POST)
	@ResponseBody
	public List<ShengecanmouModel> showHotWord(HttpServletRequest request,HttpServletResponse response){
	  
	  List<ShengecanmouModel> shengecanmouModel=shengecanmouService.showHotWord(request.getParameter("keyword"),Integer.valueOf(request.getParameter("limit")));
	  
	  logger.info(shengecanmouModel);
	  return shengecanmouModel;
	}

}
