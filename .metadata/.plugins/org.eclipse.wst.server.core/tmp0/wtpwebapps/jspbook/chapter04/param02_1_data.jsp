<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3> <%= java.net.URLDecoder.decode("22") %> </h3>
	Today is : <%= request.getParameter("date") %>
</body>
</html>