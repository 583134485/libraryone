package com.guo.ssm.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Session")
public class SessionControllerTest {
	Logger logger=Logger.getLogger(Class.class);
	
	@CrossOrigin(origins="*")
	@RequestMapping(value={"/one"})
	@ResponseBody
	public String createsession(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//不设置 网页会出现乱码
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//HttpSession session=request.getSession();
		//logger.info("session="+session.toString());
		//session.setAttribute("data", "guoxioaqun");
		Cookie[] cookies=request.getCookies();
		logger.info("cookie is"+cookies.toString());
		//String sessionid=session.getId();
		if(cookies!=null){
			response.getWriter().print(cookies.toString());
			
		}
		else{
			response.getWriter().print("第一才还没cookie");
			
		}
		
		Cookie cookie=new Cookie("time", DateTime.now().toString());
		//删除cookie 然而实际是 。cookie没有被删除,  与路径或其他原因有关
		cookie.setMaxAge(0);
		logger.info("cookie age:"+cookie.getMaxAge());
		response.addCookie(cookie);
	/*	if(session.isNew()){
			response.getWriter().print("session新的创建，id："+sessionid);
		}
		else{
			response.getWriter().print("服务器 已经存在session id"+sessionid);
			//手动销毁session
			session.invalidate();
			logger.info("手动销毁session");
		}*/
		return null;
	}
	
}
