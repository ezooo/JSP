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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
		
	if(id.equals("admin")&&pw.equals("1234"))
	{
		Cookie ckId = new Cookie("id",id);
		Cookie ckPw = new Cookie("pw",pw);
		response.addCookie(ckId);
		response.addCookie(ckPw);
		out.println("쿠키 생성 성공");
	}
	else
	{
		out.println("쿠기 생성 실패");
	}
	%>
	<%
	
	%>
</body>
</html>