package com.wx.springmvc.component;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.wx.springmvc.bean.Person;

/*
 * 自定义类型转换器
 * 	思想、Converter是ConversionService中的组件：
 * 		1、你的Converter得放进ConversionService中
 * 		2、将WebDataBinder中的ConversionService设置成我们这个加了自定义类型转换器的ConversionService
 * 
 * 	1）、实现Converter接口，实现方法
 * 	2）、配制出ConversionService。在springmvc.xml配置
 */
public class MyConvert implements Converter<String, Person>{

	@Override
	public Person convert(String str) {
		String[] strs = str.split("-");
		Person person = new Person(null, strs[0], Integer.parseInt(strs[1]), strs[2],new Date(strs[3]),Integer.parseInt(strs[4]));
		//System.out.println("Converter:"+person);
		return person;
	}
	
}
