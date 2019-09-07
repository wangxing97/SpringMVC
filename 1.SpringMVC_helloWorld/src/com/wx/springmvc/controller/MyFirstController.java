package com.wx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 1、告诉SpringMVC这是一个处理器，可以处理请求
 * 	  @Controller:标示哪个组件是控制器
 */
@Controller
public class MyFirstController {
	
	/*
	 *   /代表当前项目下开始，处理当前项目下的hello请求
	 */
	@RequestMapping("/hello")
	public String firstRequest() {
		System.out.println("请求收到了。。。正在处理中");
		return "success";
	}
}
