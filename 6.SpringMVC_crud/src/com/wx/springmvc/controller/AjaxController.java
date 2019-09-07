package com.wx.springmvc.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wx.springmvc.bean.Person;
import com.wx.springmvc.dao.PersonDao;

@Controller
public class AjaxController {

	@Autowired
	private PersonDao personDao;
	
	/*
	 * 将返回的数据放在响应体中
	 * 如果是对象自动转换成JSON格式
	 */
	@ResponseBody
	@RequestMapping(value = "/ajaxGetAll")
	public List<Person> ajaxGetAll() {
		List<Person> persons = personDao.selAllPerson();
		return persons;
	}
	
	@RequestMapping( value = "/testRequestBody")
	public String testRequestBody(@RequestBody(required = false) String body) {
		System.out.println(body);
		System.out.println("------------------");
		return "success";
	}
	
	@RequestMapping( value = "/testRequestBody02")
	public String testRequestBody02(@RequestBody Person person) {
		System.out.println(person);
		return "success";
	}
	
	@RequestMapping( value = "/responseEntityTest")
	public ResponseEntity<String> responseEntityTest() {
		HttpStatus statusCode = HttpStatus.OK;
		MultiValueMap<String, String> headers = new HttpHeaders();
		String body = "<h1>wx 66666</h1>";
		headers.add("wx-niu-bi", "wxwxwxwxwxwx");
		return new ResponseEntity<String>(body, headers, statusCode);
	}
	
	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request) throws Exception{
		
		//1、首先获取要下载文件的流
		//找到要下载文件的真实路径
		ServletContext servletContext = request.getServletContext();
		String localtion = servletContext.getRealPath("/scripts/jquery-1.7.2.min.js");
		FileInputStream is = new FileInputStream(localtion);
		System.out.println("localtion:"+ servletContext.getRealPath("/"));
		byte[] capcity = new byte[is.available()];
		is.read(capcity);
		is.close();
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=jquery-1.7.2.min.js");
		return new ResponseEntity<byte[]>(capcity, headers , HttpStatus.OK);
	}
}
