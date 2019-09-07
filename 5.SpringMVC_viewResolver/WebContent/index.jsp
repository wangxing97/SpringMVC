<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="hello">hello</a><br>
	<a href="handle02">forward:/hello.jsp</a><br>
	<a href="handle03">forward:/handle02</a><br>
	<a href="handle04">redirect:/hello.jsp</a><br>
	<a href="handle05">response.sendRedirect</a><br>
	<a href="handle06">request.getRequestDispatcher("/hello.jsp").forward(req, resp);</a><br>
	<a href="handle07">登录页面</a><br>
</body>
</html>