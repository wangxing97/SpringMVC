package com.wx.springmvc.local;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

public class MyLocaleResolver implements LocaleResolver{

	@Override
	public Locale resolveLocale(HttpServletRequest req) {
		String locale = req.getParameter("locale");
		Locale l = null;
		if(locale!=null && !locale.equals("")) {
			l = new Locale(locale.split("_")[0], locale.split("_")[1]);
		}else {
			l = req.getLocale();
		}
		return l;
	}

	@Override
	public void setLocale(HttpServletRequest arg0, HttpServletResponse arg1, Locale arg2) {
		throw new UnsupportedOperationException(
				"Cannot change HTTP accept header - use a different locale resolution strategy");
	}

}
