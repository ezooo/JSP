<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  img {
    width:20%;
    height:20%;
  }
</style>
</head>
<%
  String name= (String)request.getAttribute("name");
  String subject=(String)request.getAttribute("subject");
  String file=(String)request.getAttribute("file");
%>

<body>
    이름 : <%= name%> <br>
    제목 : <%= subject%> <br>
    파일 : <%= file%> <br> 
    <img src="img/<%=file %>">
</body>
</html>