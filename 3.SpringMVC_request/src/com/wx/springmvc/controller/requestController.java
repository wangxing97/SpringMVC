package com.wx.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wx.springmvc.bean.Book;

@Controller
public class requestController {
	
	@RequestMapping(value = "/handle01")
	public String handle01() {
		System.out.println("requestController...handle01");
		return "success";
	}
	/*
	 * 可以没有参数，默认为Null
	 */
	@RequestMapping(value = "/handle02")
	public String handle02(String username,String password) {
		System.out.println("username="+username+",password="+password); 
		System.out.println("requestController...handle02");
		return "success";
	}
	/*
	 * 使用了@RequestParam后必须传参数，否则报错，可以设置默认值和required。
	 */
	@RequestMapping(value = "/handle03")
	public String handle03(@RequestParam(value = "username",defaultValue = "王小星") String user,@RequestParam(value = "password",required = false) Integer pwd) {
		System.out.println("user="+user+",pwd="+pwd); 
		System.out.println("requestController...handle03");
		return "success";
	}
	
	/*
	 * 和@RequestParam一致有value,defaultValue,required三个属性
	 */
	@RequestMapping(value = "/handle04")
	public String handle04(@RequestHeader("User-Agent")String agent,@RequestHeader("Cookie")String cookie) {
		System.out.println("User-Agent="+agent); 
		System.out.println("Cookie="+cookie);
		System.out.println("requestController...handle04");
		return "success";
	}
	
	/*
	 * 获取某个Cookie的值
	 */
	@RequestMapping(value = "/handle05")
	public String handle05(@CookieValue("JSESSIONID") String jid,@CookieValue("_ga") String ga) {
		System.out.println("JSESSIONID="+jid); 
		System.out.println("_ga="+ga);
		System.out.println("requestController...handle05");
		return "success";
	}
	/*
	 * SpringMVC会自动的为POJO进行赋值
	 * 1)、将POJO中的每一个属性，从request参数中尝试获取出来，并封装。
	 * 2)、还可以级联封装
	 */
	/*
	 * 提交的数据可能会有乱码
	 * 请求乱码
	 * 		GET:改server.xml；在8080端口处加上 URIEncoding="UTF-8"
	 * 		POST:
	 * 			在第一次获取请求参数之前设置
	 * 			request.setCharacterEncoding("UTF-8")
	 * 			自己写一个Filter;SpringMVC给配置好了CharacterEncodingFilter,需要设置Init-Param
	 * 响应乱码
	 * 		response.setContentType("text/html;charset=utf-8");
	 */
	@RequestMapping("/book")
	public String handle06(Book book) {
		System.out.println("已获取到的书籍信息："+book);
		return "success";
	}
	
	/*
	 * SpringMVC可以直接在参数上写原生API；
	 * HttpServletRequest
	 * HttpServletResponse
	 * HttpSession
	 * java.security.Principal
	 * Locale:国际化有关的区域信息
	 * InputStream
	 * OutputStream
	 * Reader
	 * Writer
	 */
	@RequestMapping("/handle07")
	public String handle07(HttpServletRequest request,HttpSession session) {
		request.setAttribute("Param", "我是request域中的值");
		session.setAttribute("Param", "我是session域中的值");
		return "success";
	}
}
