package com.guo.ssm.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.guo.ssm.dto.Brand_Sale;
import com.guo.ssm.dto.Echart;
import com.guo.ssm.model.Taobaoshop;
import com.guo.ssm.model.TestModel;
import com.guo.ssm.model.User;
import com.guo.ssm.service.TaobaoshopService;
import com.guo.ssm.util.Brand_SaleCount;

@Controller
@RequestMapping("/taobaoecharts")
public class TaobaoEchartsController {
	Logger log=Logger.getLogger(Class.class);
	@Autowired
	TaobaoshopService taobaoshopService;
	
	
	
	
	@RequestMapping(value={"/getbrandsale"},method=RequestMethod.GET)
	public String getpageone(){
		log.info("echarts.jsp");
		return "echarts1";
	}
	@RequestMapping(value={"/getbrandsale"},method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> findone(){
		Map<String, String> map=new HashMap<String ,String>();
		map=taobaoshopService.CountAll(100000);
		/*log.info("controller map"+map);*/
		return map;
	}
	
	@RequestMapping(value={"/getlist"},method=RequestMethod.GET)
	@ResponseBody
	public List<String> testlist(){
		List<String> list = new ArrayList<String>();  
		list.add("first");  
		list.add("second");  
		return list;
	}
	
	@RequestMapping(value={"/getmapobject"},method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Brand_Sale> testmapobjec(){
Map<String,Brand_Sale> map=new HashMap<String,Brand_Sale>();
     Brand_Sale aBrand_Sale=new Brand_Sale("sdf","12321");
     Brand_Sale brand_Sale=new Brand_Sale("sdfds","333");
     map.put("sdds", aBrand_Sale);
     map.put("dd", brand_Sale); 
		return map;			
	}
	
	
	@RequestMapping(value={"/getlistmapobject"},method=RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Brand_Sale>> testlistmapobjec(){
Map<String,Brand_Sale> map=new HashMap<String,Brand_Sale>();
     Brand_Sale aBrand_Sale=new Brand_Sale("sdf","12321");
     Brand_Sale brand_Sale=new Brand_Sale("sdfds","333");
     map.put("sdds", aBrand_Sale);
     map.put("dd", brand_Sale); 
     List<Map<String, Brand_Sale>> listmap=new ArrayList<Map<String,Brand_Sale>>();
     listmap.add(map);
     listmap.add(map);
		return listmap;			
	}
	
	@RequestMapping(value={"/findshop"},method=RequestMethod.GET)
	public String findshop(){
		log.info("jsp");
		return "findshop";
	}
	
	
	//用String接收json字符串
/*	@RequestMapping(value={"/findshop"},method=RequestMethod.POST)
	@ResponseBody 
	public String findshop2(@RequestBody  String name){
		log.info(name);		
		return name;
	}*/
	
	
	//实验类接受前台json对象，实际上是json对象的字符串
	@RequestMapping(value={"/findshop"},method=RequestMethod.POST)
	@ResponseBody 
	public TestModel findshop2(@RequestBody  TestModel testModel){
       log.info(testModel.getName());
		return  testModel;
	}
	//非异步简单提交 @RequestParam用法(value="inputInt")制定参数和HttpServletRequest request 
	@RequestMapping(value={"/form"},method=RequestMethod.POST)    
	   public String filesUpload(@RequestParam (value="inputInt")String inputStrss, HttpServletRequest request) {    
	  log.info(inputStrss); 
	      
	   String inputInt = String.valueOf(request.getParameter("inputInt"));  
	   String inputStrs = String.valueOf(request.getParameter("inputStr"));  
	    log.info(inputInt+inputStrs);  
	      
	    // ......省略  
	    return "findshop";  
	   }  
	
	//json对象还是要对应具体的类的，需要对应的类
/*	@RequestMapping(value={"/findshop"},method=RequestMethod.POST)
	@ResponseBody 
	public User findshop2(@RequestBody  User testModel){
       log.info(testModel.getUsername());
		return  testModel;
	}
	*/
	//简单的表单提交   参数 形参要与前端一致，不然容易出现收不到数据
	@RequestMapping(value={"/findshop3"},method=RequestMethod.POST)
	public String findshop3(HttpServletRequest request){
       log.info(request.getParameter("FirstName"));
       log.info(request.getParameter("LastName"));
		return  "findshop";
	}
	
	@RequestMapping(value={"/findshop4"},method=RequestMethod.POST)
	public String findshop4(HttpServletRequest request){
       log.info(request.getParameter("name4"));
		return  "findshop";
	}
	
	@RequestMapping(value={"/treemap"},method=RequestMethod.GET)
	public String treemap(){
		return "treemap";
	}
	@RequestMapping(value={"/treemap2"},method=RequestMethod.GET)
	public String treemap2(){
		return "treemap2";
	}
	
	@RequestMapping(value={"/treemap2"},method=RequestMethod.POST)
	public String treemap2json(){
		return "treemap2";
	}
	
	
	
	

}
