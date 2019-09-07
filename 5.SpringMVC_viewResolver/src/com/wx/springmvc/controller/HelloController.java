package com.wx.springmvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello")
	public String handle01() {
		/*
		 * 如果想去hello.jsp
		 * 两种方式：
		 * 		1）、return "../../hello"
		 * 		2）、return "forward:/hello.jsp"
		 * 			 forward：转发到一个页面，这个返回值不会进行拼串
		 */
		return "success";
	}
	
	@RequestMapping(value = "/handle02")
	public String handle02() {
		System.out.println("handle02");
		return "forward:/hello.jsp";
	}
	
	@RequestMapping(value = "/handle03")
	public String handle03() {
		System.out.println("handle03");
		return "forward:/handle02";
	}
	
	/*
	 * 重定向到hello.jsp页面
	 * 
	 * 转发forward:转发的路径
	 * 重定向redirect:重定向的路径
	 * 	原生的Servlet重定向/路径需要加上项目名才能成功
	 * 		response.sendRedirect("/hello.jsp");不会成功！
	 */
	@RequestMapping(value = "/handle04")
	public String handle04() {
		System.out.println("handle04");
		return "redirect:/hello.jsp";
	}
	@RequestMapping(value = "/handle05")
	public void handle05(HttpServletResponse response) throws IOException {
		System.out.println("handle05");
		response.sendRedirect("/5.SpringMVC_viewResolver/hello.jsp");
	}
	
	@RequestMapping(value = "/handle06")
	public void handle06(HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException {
		System.out.println("handle06");
		request.getRequestDispatcher("/hello.jsp").forward(request, response);
	}
	
//	@RequestMapping(value = "/handle07")
//	public String handle07(){
//		System.out.println("handle07");
//		return "login";
//	}
}
