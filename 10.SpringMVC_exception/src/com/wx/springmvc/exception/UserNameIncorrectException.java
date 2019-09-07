package com.wx.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason = "用户名或密码不正确",value = HttpStatus.NOT_ACCEPTABLE)
public class UserNameIncorrectException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
}
