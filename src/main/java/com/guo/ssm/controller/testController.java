package com.guo.ssm.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.guo.ssm.dto.Echart;
import com.guo.ssm.model.EchartData;
import com.guo.ssm.model.ItemsCustom;
import com.guo.ssm.model.Series;
import com.guo.ssm.model.User;
import com.guo.ssm.service.UserService;
import com.guo.ssm.util.JsonUtil;

@Controller
@RequestMapping("/test")
public class testController {
	
	Logger log=Logger.getLogger(Class.class);

	
	@Autowired 
	UserService userService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/getjsonstring",method=RequestMethod.GET)
	@ResponseBody
	public String json(HttpServletRequest request,HttpServletResponse response){
		String json=null;
		try {
			//json=JsonUtil.ReadJsonToString("D:\\json\\data1.json");
			json=JsonUtil.ReadJsonToString("D:\\json\\datajson.json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(json);
		//@Responsebody 不适用于 直接url 数据 
		return json;
		//api url 写法 用response
		/*try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/getjsonfile",method=RequestMethod.GET)
	//@ResponseBody
	public void Responsejson(HttpServletRequest request,HttpServletResponse response){
		String json=null;
		try {
			//json=JsonUtil.ReadJsonToString("D:\\json\\data1.json");
			json=JsonUtil.ReadJsonToString("D:\\json\\datajson.json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info(json);
		//@Responsebody 不适用于 直接url 数据 
		//return json;
		//api url 写法 用response
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value={"/ajaxcontroller"},method=RequestMethod.GET)
	public String ajaxcontroller2(/*ModelMap model*/){
		log.info("get_ajaxcontroller");
		return  "ajaxcontroller";		
	}
	@RequestMapping(value={"/ajaxcontroller"},method=RequestMethod.POST)
	@ResponseBody
	public String ajaxcontroller(/*ModelMap model*/){
		log.info("_post_postajaxcontroller");
		return  "getjson";		
	}
	//get ajaxdemo
	@RequestMapping(value={"/getajaxdemo"},method=RequestMethod.POST)
	public String ajaxget3(/*ModelMap model*/){
		log.info("return");
		return  "ajaxdemo";		
	} 
	@RequestMapping(value={"/ajaxdemo"},method=RequestMethod.GET)
	public String ajaxget2(/*ModelMap model*/){
		log.info("return:ajaxdemo");
		return  "ajaxdemo";		
	}
	//ajax test用于接受前台json 数据
	@RequestMapping(value = {"/ajaxdemo"}, method = RequestMethod.POST)  
	 public  ModelAndView order(@RequestBody List<Map<String,Object>> orders) {  
	        log.info("orders size:" + orders);
	        log.info("orders size:" + orders.toString());
			return null;  
	}  
	
	@CrossOrigin( origins = "http://127.0.0.1:8020")
    @RequestMapping( value={"/getjson"},method = RequestMethod.GET)  
    @ResponseBody  
    public List<User> listUser(HttpServletRequest request,HttpServletResponse response) {  
    	List<User> lists = userService.fingAllUser(); 
    	/*List<User> lists=userService.findUserById(2);*/
    	log.info("传输数据到前台"+lists.toString());
    	//response.setHeader("Access-Control-Allow-Origin", "*");
        return lists;  
    }
    
    //传输一个类 
    @RequestMapping( value={"/getjson1"},method = RequestMethod.GET)  
    @ResponseBody  
    public User listUser2() {  
   
    	User lists=userService.findUserById(2);
    	log.info(lists.toString());
        return lists;  
    }
    
	@RequestMapping(value={"/ajaxgetdemo"},method=RequestMethod.GET)
	public String ajaxget(/*ModelMap model*/){
		log.info("return");
		return  "ajaxgetdemo";		
	}
	//接受前端传输的数据
	@CrossOrigin(origins = "*")
	@RequestMapping(value={"/ajaxgetdemo"},method=RequestMethod.POST)
	@ResponseBody
	 public  Map<String,Object> login(HttpServletRequest request,HttpServletResponse response)
			 throws IOException{  
        System.out.println("接收参数"+request.getParameter("name"));  
        Map<String,Object> map = new HashMap<String,Object>();  
    
        if(request.getParameter("name").equals("123")){  
            System.out.println("城东");  
            map.put("msg", "成功");
            map.put("name", "123");
        }else{  
            System.out.println("失败");  
            map.put("msg", "失败");  
        }  
        return map;  
    }  

	
	@RequestMapping(value={"/json"},method=RequestMethod.GET)
	public String ajaxget222(/*ModelMap model*/){
		log.info("returnjson");
		return  "json";		
	}
	//注释掉 method=RequestMethod.POST 还是接受请求
	@RequestMapping(value={"/json"} ,method=RequestMethod.POST)
	@ResponseBody
	public  ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom) {
       log.info(itemsCustom.toString());
     /*  ItemsCustom a=new ItemsCustom();
       a.setName("ssssssssss");
       a.setPrice("sdfsfdsf");
       itemsCustom=a;
       log.info(a.toString());*/
       
	    return itemsCustom; //由于@ResponseBody注解，前提是要有 fajson将itemsCustom转成json格式返回
	}	
	
	@RequiresRoles("admin")
	@RequestMapping(value={"/echarts"},method=RequestMethod.GET)
	public String echarts(/*ModelMap model*/){
		log.info("echart1.jsp");
		return  "echarts";		
	}
	
	//动态返回数据echart List<Object>
	@RequestMapping(value={"/echarts"} ,method=RequestMethod.POST)
	@ResponseBody
	public  Echart getdate() {
		//数据分组
		List<String> legend = new ArrayList<String>(Arrays.asList(new String[]{"最高气温"}));//数据分组 
		//横坐标
        List<String> category = new ArrayList<String>(Arrays.asList(new String []{"周一","周二","周三","周四","周五","周六","周日"}));//横坐标 
        //从坐标
        List<Series> series = new ArrayList<Series>();//纵坐标 
        Random random = new Random();
        int rand = random.nextInt();
        ArrayList<Long> temp = new ArrayList<>();
       
        for (int i = 0; i < 7; i++) {
               rand = Math.abs(random.nextInt()%50);
                     temp.add((long) rand);
              }
        series.add(new Series("最高气温", "line", temp)); 
  /*      EchartData data=new EchartData(legend, category, series); */
        Echart data =new Echart(legend, category, series);
        log.info(data.toString());
        return data; 
	}	
	

}
