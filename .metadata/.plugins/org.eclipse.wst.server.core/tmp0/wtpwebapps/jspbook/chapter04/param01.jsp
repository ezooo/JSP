<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>param action tag</h3>
	<jsp:forward page="param01_data.jsp">
		<jsp:param name="id" value="admin"></jsp:param>
		<jsp:param name="name" value='<%= java.net.URLEncoder.encode("관리자") %>'></jsp:param>
	</jsp:forward>
	<p>Jakarta Server Page</p>
</body>
</html>