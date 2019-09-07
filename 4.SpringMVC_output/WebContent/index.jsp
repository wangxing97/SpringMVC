<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>测试output携带参数Map、Model、ModelMap</h1>
	<a href="handle01">Map</a><br>
	<a href="handle02">Model</a><br>
	<a href="handle03">ModelMap</a><br>
	<a href="handle04">ModelAndView</a><br>
	<hr>
	<h1>测试更新图书</h1>
	<form action="updatebook" method="post">
		<input type="hidden" name="id" value="99">
		书名：喜羊羊与灰太狼<br>
		作者：<input name="author" type="text"><br>
		价格：<input name="price" type="text"><br>
		库存：<input name="stock" type="text"><br>
		销量：<input name="sales" type="text"><br>
		<input type="submit" value="提交更新">
	</form>
	<hr>
	<h1>测试自定义类型获取</h1>
	<form action="test" method="post">
		<input type="hidden" name="id" value="99">
		书名：迪迦奥特曼<br>
		作者：<input name="author" type="text"><br>
		价格：<input name="price" type="text"><br>
		库存：<input name="stock" type="text"><br>
		销量：<input name="sales" type="text"><br>
		<input type="submit" value="提交更新">
	</form>
</body>
</html>