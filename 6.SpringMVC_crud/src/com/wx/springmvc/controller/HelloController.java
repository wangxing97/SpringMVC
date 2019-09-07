package com.wx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value = "/handle01")
	public String handle01() {
		System.out.println("handle01");
		return "success";
	}
	
	@RequestMapping(value = "/shouye")
	public String handle02() {
		return "redirect:/index.jsp";
	}
}
