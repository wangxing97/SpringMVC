<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<% application.setAttribute("ctp", request.getContextPath()); %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="handle01?i=0">去登录页面~</a><br/>
	<a href="handle02?username=wx&password=wx">去登录页面自定义异常页面~</a><br/>
	<a href="handle03">xml配置错误信息~</a>
</body>
</html>