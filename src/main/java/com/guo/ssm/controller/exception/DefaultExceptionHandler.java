package com.guo.ssm.controller.exception;

import org.apache.log4j.Logger;


//controlleradvice 所有controller 错误
//@ControllerAdvice
public class DefaultExceptionHandler {
    Logger log = Logger.getLogger(getClass());
    /**
     * 没有权限 异常
     * <p/>
     * 后续根据不同的需求定制即可
     */
/*    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
        log.info("捕获异常："+e);
    	ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        //mv.setViewName("unauthorized");
        //设置视图名称，好像 还是跳转到默认的unauthoried.jsp
        mv.setViewName("alogout");
        return mv;
    }*/

}
