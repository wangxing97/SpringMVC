package com.wx.springmvc.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wx.springmvc.bean.Person;
import com.wx.springmvc.bean.Sdept;
import com.wx.springmvc.dao.PersonDao;
import com.wx.springmvc.dao.SdeptDao;

@Controller
public class PersonController {
	
	@Autowired
	PersonDao personDao;
	@Autowired
	SdeptDao sdeptDao;
	
	/*
	 * 获得所有数据 展示列表
	 */
	@RequestMapping(value = "/allPerson")
	public String allPerson(ModelMap modelMap) {
		List<Person> persons = personDao.selAllPerson();
		modelMap.addAttribute("persons", persons);
		//System.out.println(persons);
		return "allPerson";
	}
	
	/*
	 * <li><a href="addPerson">添加用户</a></li>
		<li><a href="updatePerson">更新用户</a></li>
		<li><a href="deletePerson">删除用户</a></li>
	 */
	/*
	 * 来到添加页面
	 */
	@RequestMapping(value = "/addPerson",method = RequestMethod.POST)
	public String addPerson(Model model) {
		model.addAttribute("person", new Person());
		return "addPerson";
	}
	
	/*
	 * 点击添加后
	 */
	@RequestMapping(value = "/person",method = RequestMethod.POST)
	public String Handle03(@Valid Person person,BindingResult result,Model model) {
		//加上@Valid告诉SpringMVC 这个需要校验
		//BindingResult显示校验是否成功
		boolean hasErrors = result.hasErrors();
		if(hasErrors) {
			System.out.println("校验失败");
			Map<String, Object> errorInfo = new HashMap<String, Object>();
			List<FieldError> fieldErrors = result.getFieldErrors();
			for (FieldError fieldError : fieldErrors) {
				errorInfo.put(fieldError.getField(), fieldError.getDefaultMessage());
				/*System.out.println("错误信息："+fieldError.toString());
				System.out.println("--------------");*/
			}
			model.addAttribute("errorInfo", errorInfo);
			return "addPerson";
		}else {
			System.out.println("校验成功");
			personDao.addPerson(person);
			return "redirect:/allPerson";
		}
	}
	
	/*
	 * 删除
	 */
	@RequestMapping(value = "/person/{id}",method = RequestMethod.DELETE)
	public String Handle04(@PathVariable("id")Integer id) {
		personDao.deletePerson(id);
		return "redirect:/allPerson";
	}
	
	/*
	 * 点击edit时的请求
	 */
	@RequestMapping(value = "/person/{id}",method = RequestMethod.GET)
	public String getPerson(@PathVariable("id")Integer id,Model model) {
		Person person = personDao.getPerson(id);
		//System.out.println("修改前--"+person);
		model.addAttribute("person", person);
		return "updatePerson";
	}
	
	/*
	 * 点击修改后的请求
	 */
	@RequestMapping(value = "/person/{id}",method = RequestMethod.PUT)
	public String updatePerson(@ModelAttribute(value = "person1")Person person) {
		//System.out.println("修改后--"+person);
		personDao.updatePerson(person);
		return "redirect:/allPerson";
	}
	
	@ModelAttribute
	public void myModelAttribute(@RequestParam(value = "id",required = false)Integer id,Model model) {
		if(id != null) {
			Person person = personDao.getPerson(id);
			model.addAttribute("person1", person);
			//System.out.println("hhh");
		}else {
			model.addAttribute("person1", null);
		}
		List<Sdept> sdepts = sdeptDao.getAllSdept();
		model.addAttribute("sdepts", sdepts);
	}
	
	@RequestMapping(value = "/quickaddPerson",method = RequestMethod.POST)
	public String quickaddPerson(@RequestParam("info")Person person) {
		personDao.addPerson(person);
		return "redirect:/allPerson";
	}
}
