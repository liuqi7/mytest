package com.itheima.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomGlobalException implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception exc) {
		//放异常信息的
				ItemException itemException = null;
				
				if(exc instanceof ItemException){
					itemException = (ItemException) exc;
				} else{
					itemException = new ItemException("不好意思，系统异常！请稍后重试...");
				}
				
				ModelAndView mv = new ModelAndView();
				
				//放入数据
				mv.addObject("message", itemException.getMessage());
				//返回error页面
				mv.setViewName("error");
				
				return mv;
	}

}
