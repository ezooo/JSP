<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>-----세션 삭제 전-----</h4>
	<%
		String id = (String)session.getAttribute("user_id");
		String pw = (String)session.getAttribute("user_pw");
		
		out.println("설정된 세션의 속성 이름 id : "+id +"<br>");
		out.println("설정된 세션의 속성 값 password : "+pw +"<br>");
		
		if(request.isRequestedSessionIdValid()==true)
		{
			out.print("세션 유효함");
		}
		else
		{
			out.print("세션 유효하지 않음");
		}
		
		session.invalidate();	//아예 세션을 삭제
	%>
	<h4>-----세션 삭제 후-----</h4>
	<%
		if(request.isRequestedSessionIdValid()==true)
		{
			out.print("세션 유효함");
		}
		else
		{
			out.print("세션 유효하지 않음");
		}
	%>
</body>
</html>