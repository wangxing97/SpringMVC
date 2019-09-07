package com.wx.springmvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.wx.springmvc.bean.Book;

//@SessionAttributes(value = "haha")
@Controller
public class YuanMaController {

	/*
	 * 1）、运行流程简单版
	 * 2）、确定方法每个参数的值
	 * 		1）、看是否是原生API；
	 * 		2）、看是否是Model或者Map...
	 * 		3）、都不是，看是否是简单类型；
	 * 		4）、给attrName赋值；attrName（参数标了@ModelAttribute("")就是指定了，没有就是""）
	 * 			 确定自定义类型参数
	 * 				1）、attrName使用参数的类型首字母小写；或使用@ModelAttribute("")的值
	 * 				2）、先看隐含模型中有没有这个attrName作为key对应的value，有就从中取值并赋值
	 * 				3）、看是否是@SessionAttributes(value = "wx")；标注的属性，如果是从Session中拿
	 * 						没有就会抛异常。不建议使用。
	 * 				4）、不是@SessionAttributes标注的，利用反射创建一个对象；
	 * 		5）、拿到之前创建好的对象，使用数据绑定器将请求中的每个数据绑定到这个对象上
	 */
	
	@RequestMapping("/test")
	public String test(String author,Map<String,Object> map,@ModelAttribute("qaz")Book book) {
		System.out.println("author:"+author);
		System.out.println("map:"+map);
		System.out.println("book:"+book);
		return "success";
	}
	
	@ModelAttribute
	public String ModelAttributeDemo(Map<String, Object> map) {
		System.out.println("@ModelAttribute的方法...");
		Book book = new Book("喜羊羊与灰太狼", "王小虎", 66, 55, 44);
		map.put("book", book);
		System.out.println("数据库查询到的信息："+book);
		return "success";
	}
}
