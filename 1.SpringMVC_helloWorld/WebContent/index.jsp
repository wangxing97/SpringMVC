<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<% System.out.println("页面进入了..."); %>
	<a href="hello">hello springmvc</a>
	<hr>
	<h2>给类上加RequestMapping</h2>
	<a href="handle01">RequestMapping方法上的链接...</a>
	<hr>
	<br/>
	<a href="wx/handle01">RequestMapping方法上的链接.../wx/handle01</a>
	<hr>
	<h1>测试RequestMapping的属性</h1>
	<a href="wx/handle02">RequestMapping方法上的链接.../wx/handle02</a>
	<br/>
	<h2>method属性</h2>
	<form action="wx/handle02" method="post">
		<input type="submit">
	</form>
	
	<h2>params属性</h2>
	<a href="wx/handle03">RequestMapping方法上的链接.../wx/handle03</a>
	
	<h2>headers属性</h2>
	<a href="wx/handle04">RequestMapping方法上的链接.../wx/handle04</a>
	
	<hr>
	<h1>RequestMapping-Ant风格的URL</h1>
	<a href="antTest01">RequestMapping-Ant风格.../wx/antTest01  精确匹配</a>
	<br/>
	<a href="antTest05">RequestMapping-Ant风格.../wx/antTest01  模糊匹配一个字符</a>
	<br/>
	<a href="a123/antTest0112233">RequestMapping-Ant风格.../wx/antTest01  模糊匹配多个字符</a>
	<br/>
	<a href="zxc/asd/qwe">RequestMapping-Ant风格.../wx/antTest01  模糊匹配多个字符***</a>
	<hr>
	
	<h1>测试pathVariable的属性</h1>
	<a href="user/wx">pathVariable.../user/wx</a>
</body>
</html>