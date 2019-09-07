<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Request的各种属性</h1>
	<a href="handle01">handle01</a>
	<hr>
	<a href="handle02?username=wx&password=123">携带参数后控制器方法上参数名和传过去的的参数名一致，会自动装配</a>
	<hr>
	<a href="handle03?username=wx&password=123">使用@RequestParam获取参数装配到形参上</a>
	
	<hr>
	<a href="handle04">使用@RequestHeader获取请求头参数</a>
	
	<hr>
	<a href="handle05">使用@CookieValue获取Cookie里的值</a>
	<hr>
	<form action="book" method="get">
		书名：<input name="bookName"><br/>
		作者：<input name="author"><br/>
		价格：<input name="price"><br/>
		库存：<input name="stock"><br/>
		销售量：<input name="sales"><hr>
		省:<input name="address.province"><br/>
		市:<input name="address.city"><br/>
		街道:<input name="address.street"><br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>