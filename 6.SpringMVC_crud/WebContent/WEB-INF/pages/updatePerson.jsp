<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setAttribute("cpt", application.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>更新用户</h1>
	<form:form action="${cpt}/person/${person.id}" modelAttribute="person" method="post">
		<input type="hidden" name="_method" value="PUT">
	 	id:${person.id}<br/>
	 	lastName:${person.lastName}<br/>
	 	<input type="hidden" name="id" value="${person.id}">
	 	<%-- <input type="hidden" name="id" value="${person.id}">
	 	<input type="hidden" name="lastName" value="${person.lastName}"> --%>
	 	<form:input path="age"/><br/>
	 	<form:input path="email"/><br/>
	 	<form:input path="birth"/><br/>
	 	<form:select path="sdeptId" items="${sdepts}" itemLabel="sdeptName" itemValue="sdeptId" >
	 	</form:select><br/>
	 	<input type="submit" value="修改">
	</form:form>
</body>
</html>