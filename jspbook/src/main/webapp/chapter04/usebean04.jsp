<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="chapter04.person" scope="request"></jsp:useBean>
	<p> 아이디 : <%= person.getId() %> </p>
	<p> 이 름 : <%= person.getName() %> </p>
	<%
		person.setId(20230923);
		person.setName("홍길동");
	%>
	<jsp:include page="usebean03.jsp"></jsp:include>	
</body>
</html>