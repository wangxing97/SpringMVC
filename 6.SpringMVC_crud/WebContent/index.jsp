<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	request.setAttribute("cpt", request.getContextPath());
%>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.7.2.min.js"></script>
</head>
<body>
	<a href="handle01">click me</a>
	<hr>

	<ul>
		<li>
			<form action="addPerson" method="post">
				<input type="submit" value="添加用户">
			</form>
		</li>
		<li><a href="allPerson">更新用户</a></li>
		<li><a href="allPerson">查询用户</a></li>
		<li><a href="allPerson">删除用户</a></li>
		<form action="quickaddPerson" method="post">
			<input type="text" value="personName-25-Name@qq.com-2019/1/1-102"
				name="info"> <input type="submit" value="快速添加">
		</form>
	</ul>

	<hr />
	<%=new Date()%>
	<a href="${cpt}/ajaxGetAll" id="ajaxTest">ajax</a>
	<div id="displayPerson"></div>
	<hr>

	<form action="${cpt }/testRequestBody" method="post"
		enctype="multipart/form-data">
		<input type="text" name="username" value="wangxing"> <input
			type="password" name="password" value="123456"> <input
			type="file" name="file"> <input type="submit"
			value="requestBody">
	</form>
	<hr>
	<a id="requestBodyBtn" href="${cpt}/testRequestBody02">给服务器发送请求</a>
	<hr>
	<a href="${cpt}/responseEntityTest">ResponseEntity</a>
	<hr>
	<a href="${cpt}/download">download</a>
	<script type="text/javascript">
		$("#ajaxTest").click(function(){
			$.ajax({
				url:"${cpt}/ajaxGetAll",
				type:"POST",
				success: function(data){
					$.each(data,function(){
						let personInfo = this.lastName+"-->"+this.age+"-->"+this.email+"-->"+this.birth;
						$("#displayPerson").append(personInfo+"<br/>");
					})
				}
			});
			return false;
		});
		$("#requestBodyBtn").click(function(){
			var str = {
				lastName : "小狗蛋",
				age : 18,
				email : "goudan@163.com",
				birth : "1656-5-6"
			}
			var strJson = JSON.stringify(str);
			$.ajax({
				url : "${cpt}/testRequestBody02",
				type : "POST",
				contentType : "application/json",
				data : strJson,
				success: function(data){
					alert(data);
				}
			})
			return false;
		});
	</script>
</body>
</html>