<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	pageContext.setAttribute("ctp", request.getContextPath());
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${ msg }<br/>
	<form action="${ctp }/upload" method="post" enctype="multipart/form-data">
		头像：<input type="file" name="header"><br/>
		用户名：<input type="text" name="username"><br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>