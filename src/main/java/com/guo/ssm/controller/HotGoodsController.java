package com.guo.ssm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.guo.ssm.model.NewHotGoodsModel;
import com.guo.ssm.service.TaobaoshopService;
import com.guo.ssm.util.FileDaoUtil;


@CrossOrigin(origins="*")
@Controller
@RequestMapping("/HotGoods")
public class HotGoodsController {
	static final Logger log=LoggerFactory.getLogger(HotGoodsController.class);
	
	
	@Autowired
	TaobaoshopService taobaoshopService;
	
	//展示没软用
/*	@Autowired
	ServletContext context;*/
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/showhotgoods",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,List> showhotgoods(){
		Map map=new HashMap<String, List>();
		map=taobaoshopService.ShowHotGoods("F:\\excel\\hot2.xlsx");
		return map;
	}
	
	@RequestMapping(value="/showhotgoods",method=RequestMethod.GET)
	public String show(){
		return "hotgoods";
	}
	
	@RequestMapping(value="/shownewhot",method=RequestMethod.GET)
	public String show2(){
		return "NewHotGoods";
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/shownewhotgoods",method=RequestMethod.POST)
	@ResponseBody
	public NewHotGoodsModel showhot2(HttpServletRequest request,HttpServletResponse response){
		String choose=request.getParameter("name");
		NewHotGoodsModel newHotGoodsModel=new NewHotGoodsModel();
		
	/*	if(choose.contains("0")){
			log.info("选择了一");
			newHotGoodsModel=taobaoshopService.ShowNewHotGoods("F:\\excel\\0.xlsx");
			log.info("成功读取"+newHotGoodsModel);
		}
		else if (choose.contains("1")){

			newHotGoodsModel=taobaoshopService.ShowNewHotGoods("F:\\excel\\1.xlsx");
		}
		else if(choose.contains("2")){
			newHotGoodsModel=taobaoshopService.ShowNewHotGoods("F:\\excel\\2.xlsx");
		}*/
		//读取excel文档
	newHotGoodsModel=taobaoshopService.ShowNewHotGoods("D:\\fileUpload\\"+choose+".xlsx");
		return newHotGoodsModel;
	}
	
	
	
	@RequestMapping(value="/fileUpload",method=RequestMethod.GET)
	public String fileUpload(){
		return "UploadFile";
	}
	
	// uploadOneFile.jsp, uploadMultiFile.jsp submit to.
	@CrossOrigin(origins = "*")
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    @ResponseBody
    public /*void*/ String uploadFileHandler(HttpServletRequest request,HttpServletResponse response, Model model,
            @RequestParam("file") MultipartFile[] files) {
		
	   FileDaoUtil fileDaoUtil=new FileDaoUtil();
	   String msg=fileDaoUtil.UploadFiles(files);
        //model.addAttribute("uploadedFiles", uploadedFiles);
        return msg;
        
    }
	
	// uploadOneFile.jsp, uploadMultiFile.jsp submit to.
	@CrossOrigin(origins = "*")
    @RequestMapping(value = "/dodownload", method = RequestMethod.GET)
    @ResponseBody
    public  String FileDownLoad(HttpServletRequest request,HttpServletResponse response) throws Exception {
   FileDaoUtil fileDaoUtil =new FileDaoUtil();
		String  msg = fileDaoUtil.FileDownLoad(request, response);
        return msg;
        
    }
	
	//前端验证时候，异步验证接口
	@CrossOrigin(origins = "*")
    @RequestMapping(value = "/remote", method = RequestMethod.POST)
    @ResponseBody
    public  String romotevalid(HttpServletRequest request,HttpServletResponse response) throws Exception {
         String firstname=request.getParameter("firstname");
       //  String id=request.getParameter("id");
         log.info("firstname:"+firstname);
         //log.info("id:"+id);
         String b=new String();
         if(firstname.contains("666")){
        	 b="true";
         }
         else {
        	 b="false";
         }
         log.info(b);
        return b;
        
    }
	//前端验证时候，异步验证接口
	@CrossOrigin(origins = "*")
    @RequestMapping(value = "/remoteid", method = RequestMethod.POST)
    @ResponseBody
    public  String romotevalid2(HttpServletRequest request,HttpServletResponse response) throws Exception {
         String id=request.getParameter("idtext");
        
         log.info("id:"+id);
         String b=new String();
         if(id.contains("666")){
        	 b="true";
         }
         else {
        	 b="false";
         }
         log.info(b);
        return b;
        
    }

}
