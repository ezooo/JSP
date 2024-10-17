<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>------- 기본 로케일 --------</p>
		<fmt:setLocale value="ko" />
		<!-- ko 없지만 defalut 쓰게 하기 위해서 없는거 넣어준 것 (운영체제 설정 상 영어가 나올 수 있기 때문) -->
		<fmt:setBundle basename="chapter09.bundle.myBundle" var="resourceBundle"></fmt:setBundle>
		<p> 제목 : <fmt:message key="title" bundle="${resourceBundle}" /></p>
		<p> <fmt:message key="username" var="userMsg" bundle="${resourceBundle}" /></p>
		이름 : ${userMsg }
		
	<p>------- 영문 로케일 --------</p>
		<fmt:setLocale value="en" />
		<fmt:setBundle basename="chapter09.bundle.myBundle" var="resourceBundle"></fmt:setBundle>
		<p> 제목 : <fmt:message key="title" bundle="${resourceBundle}" /></p>
		<p> 이름 : <fmt:message key="username" bundle="${resourceBundle}" /></p>
</body>
</html>