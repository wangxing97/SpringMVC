<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setAttribute("cpt", application.getContextPath());%>
<script type="text/javascript" src="${cpt }/scripts/jquery-1.7.2.min.js" ></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>用户信息</h1>
	<table border="1" >
		<tr>
			<th>id</th>
			<th>lastName</th>
			<th>age</th>
			<th>email</th>
			<th>birth</th>
			<th>sdeptName</th>
			<th>edit</th>
			<th>delete</th>
		</tr>
		<c:forEach items="${persons}" var="person">
			<tr>
				<td>${ person.id }</td>
				<td>${ person.lastName }</td>
				<td>${ person.age }</td>
				<td>${ person.email }</td>
				<th>${ person.birth }</th>
				<td>
					<c:if test="${person.sdeptId eq '101'}">
						信息部
					</c:if>
					<c:if test="${person.sdeptId eq '102'}">
						技术部
					</c:if>
					<c:if test="${person.sdeptId eq '103'}">
						测试部
					</c:if>
					<c:if test="${person.sdeptId eq '104'}">
						开发部
					</c:if>
				</td>
				<td><a href="${cpt}/person/${person.id}">edit</a></td>
				<td>
					<a href="${cpt}/person/${person.id}" class="delbtn">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="shouye">返回</a>
	<form id="deleteForm" action="${cpt}/person/${person.id}" method="post" >
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="delete" hidden="true">
	</form>
	<script type="text/javascript">
		$(function(){
			$(".delbtn").click(function(){
				if(confirm("确定要删除？")){
					$("#deleteForm").attr("action",this.href);
					$("#deleteForm").submit();
				}
				return false;
			})
		});
	</script>
</body>
</html>