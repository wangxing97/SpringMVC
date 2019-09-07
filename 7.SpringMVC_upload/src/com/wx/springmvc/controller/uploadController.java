package com.wx.springmvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class uploadController {

	/*
	 * 使用MultipartFile获取文件信息
	 */
	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public String upload(@RequestParam(value = "username",required = false)String username
			,@RequestParam("header")MultipartFile file,Model model) {
		System.out.println("文件名："+file.getOriginalFilename());
		try {
			file.transferTo(new File("D:\\Download\\"+file.getOriginalFilename()));
			model.addAttribute("msg", "文件上传成功!");
		} catch (Exception e) {
			model.addAttribute("msg", "文件上传失败!");
		}
		return "forward:/index.jsp";
	}
}
