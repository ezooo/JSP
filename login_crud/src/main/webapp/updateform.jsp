<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "dto.member_dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateform</title>
</head>
<body>
<%
	member_dto dto = (member_dto)request.getAttribute("DTO");
%>
	<form action="update" method="post">
		<p> ID : <input type="text" name="id" value="<%=dto.getId()%>" readonly> </p>
		<p> PW : <input type="text" name="pw" value="<%=dto.getPw()%>"> </p>
		<p> AGE : <input type="text" name="age" value="<%=dto.getAge()%>"> </p>
		<p> <input type="submit" value="수정하기"> </p>
	</form>
</body>
</html>