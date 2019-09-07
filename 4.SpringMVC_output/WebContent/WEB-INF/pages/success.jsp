<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	page：${ pageScope.msg }<br/>
	request：${ requestScope.msg }<br/>
	session：${ sessionScope.msg }<br/>
	application：${ applicationScope.msg }<br/>
</body>
</html>