package com.wx.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyHandlerException {

	@ExceptionHandler(value = ArithmeticException.class)
	public ModelAndView ArithException(ArithmeticException e) {
		System.out.println("全局:ArithmeticException");
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorInfo", e);
		return mv;
	}
	
	/*@ExceptionHandler(value = Exception.class)
	public ModelAndView AllException(Exception e) {
		System.out.println("全局:Exception");
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorInfo", e);
		return mv;
	}*/
}
