<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Enumeration en = request.getHeaderNames();
		while( en.hasMoreElements() )
		{
			String headerName = (String)en.nextElement();	//request로 받은거 데이터 타입 알 수 없으므로 강제 형변환
			String headerValue = request.getHeader(headerName);
	%>
	<%= headerName %> : <%= headerValue %><br>
	<%
		}	//while 닫기
	%>
</body>
</html>