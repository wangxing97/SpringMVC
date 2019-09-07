package com.wx.springmvc.controller;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wx.springmvc.bean.Book;
/*
 * SpringMVC除了在方法上传入原生的request和session外还能怎么样吧数据带给页面
 * 	1）、可以在方法处传入Map、Model、ModelMap
 * 		 	这些参数保存的数据都会放在request域中，可以在页面进行获取
 * 		关系：
 * 			这三种方式都是BindingAwareModelMap在工作
 * 			相当于给BindingAwareModelMap中保存的东西都会被放在请求域中
 *  2）、方法的返回值可以变为ModelAndView类型
 *  		既包含视图信息（页面地址）也包含模型数据（给页面带的数据）	
 *  		而且数据是放在请求域中的；
 *  		request、session、application
 *  3）、SpringMVC提高了一种可以临时给Session域中保存数据的方式；
 *  		使用一个注解   @SessionAttributes 只能标在类上
 *  		@SessionAttributes( value = "msg")
 *  		同时给Session中放一份msg为key的value
 *  		@SessionAttributes(types = {String.class})
 *  		将所有String类型的都放入Session域中一份
 */

@SessionAttributes( value = "msg",types = {String.class})
@Controller
public class OutPutController {
	
	@RequestMapping(value = "/handle01")
	public String handle01(Map<String, Object> map) {
		System.out.println("handle01");
		map.put("msg", "map的value");
		return "success";
	}
	@RequestMapping(value = "/handle02")
	public String handle02(Model model) {
		model.addAttribute("msg", "model的value");
		return "success";
	}
	@RequestMapping(value = "/handle03")
	public String handle03(ModelMap modelMap) {
		modelMap.addAttribute("msg", "modelMap的value");
		return "success";
	}
	
	@RequestMapping(value = "/handle04")
	public ModelAndView handle04() {
		ModelAndView view = new ModelAndView();
		//需要返回的视图名就是 StringName
		view.setViewName("success");
		view.addObject("msg", "ModelAndView的value");
		return view;
	}
	
	/*
	 * 让SpringMVC别创建Book对象，直接从数据库先取出一个id=99的Book对象，将其封装
	 * 在将从页面传来的数据覆盖到这个Book对象然后进行更新操作。
	 */
	@RequestMapping(value = "/updatebook")
	public String updateBook(@ModelAttribute(value = "book")Book book) {
		System.out.println("更新后信息book:"+book);
		return "success";
	}
	
	/*
	 * @ModelAttribute
	 * 		参数：取出刚才保存的数据
	 * 		方法：这个方法会提交于目标方法之前先运行
	 * 			1)、可以先将数据库信息查询出来封装成对象
	 * 			2)、利用map、model、modelMap将对象保存
	 * 			里面的参数还是BindingAwareModelMap
	 */
	@ModelAttribute
	public String ModelAttributeDemo(Map<String, Object> map) {
		System.out.println("@ModelAttribute的方法...");
		Book book = new Book("喜羊羊与灰太狼", "王小虎", 66, 55, 44);
		map.put("book", book);
		System.out.println("数据库查询到的信息："+book);
		return "success";
	}
}
