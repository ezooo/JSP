<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 겟애트리뷰트 -->
	<%
		String message = (String)request.getAttribute("message");
		String idd = (String)request.getAttribute("id");
		String passwdd = (String)request.getAttribute("password");
	%>
	<%= message %>
	입력된 id 값 : <%= idd %>
	입력된 pw 값 : <%= passwdd %>
</body>
</html>