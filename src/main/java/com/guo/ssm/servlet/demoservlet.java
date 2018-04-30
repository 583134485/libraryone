package com.guo.ssm.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class demoservlet  extends HttpServlet{
	
	Logger log=Logger.getLogger(getClass());
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	log.info("doget22");

}
	
    //servlet 接受json
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.print("post");
		
	    //System.out.println("getparameter"+req.getParameter("name"));
//		PrintWriter out=resp.getWriter();
//		out.print("{'errorCode':0,'type':'en2zh-CHS'}");
//		out.flush();
//		out.close();
		BufferedReader reader=new BufferedReader(new InputStreamReader(req.getInputStream()));
		StringBuffer sBuffer=new StringBuffer("");
		String temp;
		while((temp=reader.readLine())!=null){
			sBuffer.append(temp);
			
			System.out.print(sBuffer.toString());
		}
		reader.close();
		PrintWriter out=resp.getWriter();
		out.print("{'errorCode':0,'type':'en2zh-CHS'}");
		out.flush();
		out.close();	
	}
	

}
