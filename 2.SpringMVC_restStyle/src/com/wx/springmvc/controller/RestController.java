package com.wx.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {
	
	@RequestMapping("/handle01")
	public String handle01() {
		System.out.println("RestController...handle01");
		return "success";
	}
	
	@RequestMapping(value = "/book/{bid}",method = RequestMethod.POST)
	public String addBook(@PathVariable("bid")Integer bookId) {
		System.out.println("增加"+bookId+"号图书成功!");
		return "success";
	}
	
	@RequestMapping(value = "/book/{bid}",method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable("bid")Integer bookId) {
		System.out.println("删除"+bookId+"号图书成功!");
		return "success";
	}
	
	@RequestMapping(value = "/book/{bid}",method = RequestMethod.PUT)
	public String updateBook(@PathVariable("bid")Integer bookId) {
		System.out.println("修改"+bookId+"号图书成功!");
		return "success";
	}
	
	
	@RequestMapping(value = "/book/{bid}",method = RequestMethod.GET)
	public String getBook(@PathVariable("bid")Integer bookId) {
		System.out.println("查询"+bookId+"号图书成功!");
		return "success";
	}
}
