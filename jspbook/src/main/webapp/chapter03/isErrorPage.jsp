<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page_isErrorPage</title>
</head>
<body>
	<h4>에러가 발생했습니다.</h4>
	<h5>exception 내장 객체 변수</h5>
	<%
		exception.printStackTrace( new java.io.PrintWriter(out) );
		//exception 객체 생성 안함 import 안함 : 그냥 사용할 수 있음
	%>
</body>
</html>