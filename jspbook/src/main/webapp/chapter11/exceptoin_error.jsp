<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> 오류 발생 </p>
	<p> 예외 : <%= exception %> </p>
	<p> toString() : <%= exception.toString() %> </p>
	<p> getClass().getName() : <%= exception.getClass().getName() %> </p>
	<p> getMessage() : <%= exception.getMessage() %> </p>
</body>
</html>