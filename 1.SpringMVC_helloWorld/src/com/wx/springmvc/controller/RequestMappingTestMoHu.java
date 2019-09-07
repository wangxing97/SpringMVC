package com.wx.springmvc.controller;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @RequestMapping的模糊匹配功能
 * 
 * URL地址可以写模糊的通配符：
 * 		？：能替代任意一个字符，0个或多匹配都会报错
 * 			 多个匹配下，精确优先
 * 		 * ：能替代多个字符，和一层路径
 * 			 同匹配多个时, ? > * > **
 * 		**：能替代多层路径
 */
@Controller
public class RequestMappingTestMoHu {
	
	@RequestMapping("/antTest01")
	public String antTest01() {
		System.out.println("RequestMapping...andTest01 精确匹配...");
		return "success";
	}
	
	@RequestMapping("/antTest0?")
	public String antTest02() {
		System.out.println("RequestMapping...andTest02 模糊匹配一个字符..");
		return "success";
	}
	
	@RequestMapping("/a*/antTest0*")
	public String antTest03() {
		System.out.println("RequestMapping...andTest03 模糊匹配多个字符..");
		return "success";
	}
	
	@RequestMapping("/**/**")
	public String antTest04() {
		System.out.println("RequestMapping...andTest04模糊匹配多个字符**..");
		return "success";
	}
	
	//路径上可以由占位符：占位符 语法就是可以在任意路径的地方写一个{变量名}
	//  /user/admin       /user/wx
	@RequestMapping("/user/{id}")
	public String pathVariableTest(@PathVariable("id")String id) {
		System.out.println("RequestMapping...pathVariableTest..id:"+id);
		return "success";
	}
	/*
	 * Rest风格
	  *  系统希望以非常简洁的URL地址来发请求
	 * GET：获取资源
	 * POST：新建资源
	 * PUT：更新资源
	 * DELETE：删除资源
	 * 
	 * Rest推荐URL起名格式：/资源名/资源标识符
	 * 	问题从页面上只能发两种请求，GET、POST
	 * 	其他请求方式没法使用
	 */
}
