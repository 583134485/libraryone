package com.guo.ssm.controller.exception;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


//统一异常,service端异常
//统一参数异常统一处理
//统一controller端日志
@ControllerAdvice
public class GlobalExceptionHandler {
  private final static Logger log=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
  
  /**
   * 处理所有不可知的异常
   * @param e
   * @return
   */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	String handelException(Exception e){
		log.error(e.getMessage(),e);
		return "something error unknown"+e.getMessage();
	}
	
    /**
     * 处理所有业务异常
     * @param  serviceexception e
     * @return
     */
	//@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "业务异常，针对控制器处理")
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	String handleService(ServiceException e){
		log.error(e.getMessage(),e);
		return "service exception"+e.getMessage();
	}
	
	@ExceptionHandler(BindException.class)
	@ResponseBody
	 String validEeceptionHandler(BindException e) {
		List<FieldError> fieldErrors=e.getBindingResult().getFieldErrors();
         log.error("error size"+fieldErrors.size());
		for (FieldError error:fieldErrors){
            log.error(error.getField()+":"+error.getDefaultMessage());
            log.info("----");
        }


	    return "error return:"+e.getMessage();
	}
	
}
