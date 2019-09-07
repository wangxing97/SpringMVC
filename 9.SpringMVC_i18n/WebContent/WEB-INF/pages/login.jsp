<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><fmt:message key="welcomeInfo"/></h1>
	<form action="">
		<fmt:message key="username"/>：<input><br/>
		<fmt:message key="password"/>：<input><br/>
		<input type="submit" value="<fmt:message key="loginBtn"/>">
	</form>
	<a href="tologinpage?locale=ch_CH">中文</a>||<a href="tologinpage?locale=en_US">英文</a>
</body>
</html>