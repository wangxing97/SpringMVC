package com.wx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wx.springmvc.exception.UserNameIncorrectException;

@Controller
public class ExceptionTestController {

	@RequestMapping( value = "/handle01")
	public String handle01(Integer i) {
		System.out.println("handle01...");
		System.out.println("数学运算10/"+i+"="+10/i);
		return "success";
	}
	
	@RequestMapping( value = "/handle02")
	public @ResponseBody String handle02(String username,String password) throws UserNameIncorrectException{
		System.out.println("handle02...");
		if(!username.equals(password)) {
			System.out.println("登录失败");
			throw new UserNameIncorrectException();
		}
		System.out.println("登录成功");
		return "success";
	}
	
	@RequestMapping( value = "/handle03")
	public @ResponseBody String handle03(){
		System.out.println("handle03...");
		String str = null;
		System.out.println(str.toUpperCase());
		return "success";
	}
	/*@ExceptionHandler(value = Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mv = new ModelAndView("error");
		System.out.println("handleException");
		mv.addObject("errorInfo", e);
		return mv;
	}*/
}
