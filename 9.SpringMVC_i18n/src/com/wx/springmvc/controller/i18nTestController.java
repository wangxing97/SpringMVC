package com.wx.springmvc.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
public class i18nTestController {

	@RequestMapping( value = "/tologinpage" )
	public String toLoginPage(@RequestParam(value = "locale",defaultValue = "ch_CN")String localeStr,HttpServletRequest req,HttpSession session) {
		Locale locale = req.getLocale();
		System.out.println("区域信息："+locale);
		System.out.println("区域语言："+locale.getLanguage());
		/*Locale l = null;
		if(locale!=null && !locale.equals("")) {
			l = new Locale(localeStr.split("_")[0], localeStr.split("_")[1]);
		}else {
			l = req.getLocale();
		}
		session.setAttribute(SessionLocaleResolver.class.getName() + ".LOCALE", l);*/
		return "login";
	}
}
