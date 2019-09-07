<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% request.setAttribute("cpt", application.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>添加用户</h1>
	<%
		/*
			GET:获取
			POST:新建
			PUT:更新
			DELETE:删除
		*/
	%>
	<%-- <form action="person" method="post">
		lastName:<input type="text" name="lastName"><br/>
		age:<input type="text" name="age"><br/>
		email:<input type="text" name="email">
		<select name="sdeptId">
			<c:forEach items="${ sdepts }" var="sdept">
				<option value="${sdept.sdeptId}">${sdept.sdeptName}</option>
			</c:forEach>
		</select>
		<input type="submit" value="添加">
	</form> --%>
	<form:form action="${cpt}/person" method="post" modelAttribute="person">
		lastName:<form:input path="lastName"/>
		<form:errors path="lastName"/>--->
		${ errorInfo.lastName } <br/>
		age:<form:input path="age"/>
		<form:errors path="age"/>--->
		${ errorInfo.age } <br/>
		email:<form:input path="email"/>
		<form:errors path="email"/>--->
		${ errorInfo.email } <br/>
		birth:<form:input path="birth"/><br/>
		<form:select path="sdeptId" items="${sdepts}" itemLabel="sdeptName" itemValue="sdeptId"></form:select>
		<br/>
		<input type="submit" value="添加">
	</form:form>
</body>
</html>