<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session = request.getSession(false);	//페이지 이동했으니까 세션 다시 연결하rl
		//false 해야 새로 안 만듦
		String id = (String)session.getAttribute("log_id");
		String msg = (String)session.getAttribute("message");
		
		//out.println(id+msg);
	%>
	<%= msg %>

</body>
</html>