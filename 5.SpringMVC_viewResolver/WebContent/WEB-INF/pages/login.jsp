<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1><c:message key="welcomeinfo"/></h1>
	<form action="">
		<c:message key="username"/>：<input><br>
		<c:message key="userpwd"/>：<input><br>
		<input type="submit" value="<c:message key="loginbtn"/>">
	</form>
</body>
</html>