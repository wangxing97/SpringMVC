package com.wx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

	@RequestMapping(value = "/handle01")
	public String handle01() {
		System.out.println("handle01处理方法...");
		return "success";
	}
	
	@RequestMapping(value = "/handle02")
	public String handle02() {
		System.out.println("handle02处理方法...");
		return "success";
	}
}
