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
<a href="${ctp }/handle01">Test Interceptor</a>
</body>
</html>