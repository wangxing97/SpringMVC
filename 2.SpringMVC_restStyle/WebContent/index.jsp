<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>测试Rest风格</h1>
	<!-- 
		  请求URL   请求方式   表示含义
		 /book/1   GET     获取1号图书
		 /book     POST    增加图书
		 /book/1   PUT     修改1号图书
		 /book/1   DELETE  删除1号图书
		 没有PUT、DELETE需要在XML中配置HiddenHttpMethod的Filter
		 步骤
		 	1)、创建一个post类型的表单
		 	2)、表单项中携带一个_method的参数
		 	3)、这个参数中value就是DELETE、PUT
	 -->
	<a href="book/1">查询图书</a>
	
	<form action="book/1" method="post">
		<input type="submit" value="增加图书">
	</form>
	<form action="book/1" method="post">
		<input type="hidden" name="_method" value="PUT">
		<input type="submit" value="修改图书">
	</form>
	
	<form action="book/1" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="删除图书">
	</form>
</body>
</html>