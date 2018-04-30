package com.guo.ssm.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guo.ssm.dto.JsonDemoDto;
import com.guo.ssm.service.TaobaoshopService;

@Controller
@RequestMapping("/Treemaps")
public class TreeMapController {
	Logger log=Logger.getLogger(Class.class);
	@Autowired
	TaobaoshopService taobaoshopService;
	
	@RequestMapping(value={"/treemap"},method=RequestMethod.GET)
	public String showtreemap(){
		log.info("login treemap");
		return "treemap";
	}
	
	//传递的是json字符传所以jsp接受对象要转化
	@CrossOrigin(origins = "*")
	@RequestMapping(value={"/showtreemap"})
	@ResponseBody
	public List<JsonDemoDto> showtreemap1(){
		List <JsonDemoDto> jsonDemoDtos=taobaoshopService.ShowTreeMap("zengliu旗舰店");
		//jsonDemoDtos.addAll(taobaoshopService.ShowTreeMap("雅莹官方旗舰店"));
		return jsonDemoDtos;
	}
	
	
}
