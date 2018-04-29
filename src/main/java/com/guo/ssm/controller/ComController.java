package com.guo.ssm.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guo.ssm.shiro.service.UserModelService;

/** 
* @author  作者 E-mail:
* @date 创建时间：2017年10月10日 上午8:55:09
* @version 1.0 
* @parameter  
* @Description: TODO(通用类controller) 
* @since  
* @return  */

@Controller
//@RequestMapping("/")
public class ComController {
	Logger logger=Logger.getLogger(Class.class);
	
	@Autowired
	UserModelService userService;
/*	
	@RequestMapping(value={"/login"},method=RequestMethod.GET)
	public String gotologin (){
		return "login";
	}
	
	
	@RequestMapping(value={"/login"},method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest req){
		logger.info("login");
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        logger.info(exceptionClassName);
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
		return "login";
	}*/
	@CrossOrigin(origins="*")
    @RequestMapping(value = "/loginforperson")
	@ResponseBody
    public String login(HttpServletRequest request) {
    	logger.info("login for person");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("admin")||password.equals("admin")) {
			return "true";
		}

		
        return "false";
    }
	
	
	@CrossOrigin(origins="*")
    @RequestMapping(value = "/login")
    public String showLoginForm(HttpServletRequest req) {
    	logger.info("login");
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } if(exceptionClassName != null) {
        	error = "其他错误";
          //logger.info("error:"+exceptionClassName);
        }
       logger.info(error);
        return "login";
    }
    @CrossOrigin(origins="*")
	@RequestMapping(value={"/register"},method=RequestMethod.GET)
	public String register(){
		return "register";
	}
    
	@CrossOrigin(origins="*")
	@RequestMapping(value={"/register"},method=RequestMethod.POST)
	@ResponseBody
	public String postregister(HttpServletRequest request){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		logger.info("postuser:"+username+password);
		userService.addUser(username, password);
		
		return "yesbaby";
	}
	
	//异步验证用户名存在
	@CrossOrigin(origins="*")
	@RequestMapping(value={"/valiregister"},method=RequestMethod.POST)
	@ResponseBody
	public Boolean validateusername(HttpServletRequest request){
		String username=request.getParameter("username");
		logger.info(username);
		/*if(username.equals("6666")){
			return true;
		}
		else{
			return false;
		}*/
		//已存在 用户名
		if(userService.findByUsername(username)!=null){
			logger.info("存在用户");
			return false;
		}
		return true;
	}
	/*
	@RequestMapping(value={"/reallogout"},method=RequestMethod.GET)
	public String logout (){
		return "logout";
	}*/
	

}
