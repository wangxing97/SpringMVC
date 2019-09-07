package com.wx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 为当前类所有的方法的请求地址指定一个基准路径
 */
@RequestMapping("/wx")
@Controller
public class RequestTestMapping {

	@RequestMapping("/handle01")
	public String handle01() {
		System.out.println("RequestMapping...handle01");
		return "success";
	}
	
	/*
	 * @RequestMapping的方法
	 * value():指定映射的处理请求地址
	 * method():限定请求方式
	 * 		GET、POST
	 * 		method = RequestMethod.POST:只接收这种类型的请求，默认是什么都接收
	 * params():规定请求参数
	 * 		param1:表示请求必须包含名为param1的请求参数
	 * 		!param1:表示请求不能包含名为param1的请求参数
	 * 		param1 != value1:表示请求包含名为param1的请求参数，但其值不能为value1
	 * 		{"param1=value1","param2"}，请求必须包含名为param1和param2的请求参数，而且param1的值必须为value1
	 * headers():规定请求头;也和params一样写表达式
	 * consumes():只接受内容类型是哪种的请求，规定请求头上Content-Type
	 * produces():告诉浏览器返回的内容类型是什么，给响应头上加上Content-Type:text/html;charset=utf-8
	 */
	@RequestMapping(value = "/handle02",method = RequestMethod.POST)
	public String handle02() {
		System.out.println("RequestMapping...handle02");
		return "success";
	}
	
	/*
	 * params = {"username"} 必须带有username请求参数
	 * params = {"!username"} 不能带有username请求参数
	 * params = {"username=wx","password!=123"} 必须携带username请求参数，可以不带password
	 * 			                                 username必须等于wx,password如果带了不能是123
	 */
	@RequestMapping(value = "/handle03",params = {"username=wx","password!=123"})
	public String handle03() {
		//params():规定请求参数
		System.out.println("RequestMapping...handle03");
		return "success";
	}
	
	/*
	 * User-Agent:浏览器信息
	 *  让谷歌可以访问，IE不可以访问
	 *  谷歌：User-Agent: Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.80 Safari/537.36
	 * IE： User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; Trident/7.0; rv:11.0) like Gecko
	 */
	@RequestMapping(value = "/handle04",headers = {"User-Agent=Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.80 Safari/537.36"})
	public String handle04() {
		//headers():规定请求头;也和params一样写表达式
		System.out.println("RequestMapping...handle04");
		return "success";
	}
}
