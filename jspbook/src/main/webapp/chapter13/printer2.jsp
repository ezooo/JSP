<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<%
		session = request.getSession(false);
		String id = (String)session.getAttribute("id");
		String password = (String)session.getAttribute("pw");
	%>
	로그인2
	<%= id %><br>
	<%= password %>
</body>
</html>