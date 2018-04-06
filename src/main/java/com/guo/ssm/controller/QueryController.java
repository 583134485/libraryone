package com.guo.ssm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/*数据查询 query接口*/
@Controller
@RequestMapping("/query")
public class QueryController {
	private  static final Logger log=LoggerFactory.getLogger(QueryController.class);
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/error")
	@ResponseBody
	public String testerror(){
		throw new RuntimeException();
		//return "query api ready";
	}
    /*跨域*/
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/")
	@ResponseBody
	public String query(){
		return "query api ready";
	}
	
	
	
	
	

}
