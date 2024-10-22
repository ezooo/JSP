<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam13_1_print</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("passwd");
		
		if(id.equals("admin") && pw.equals("1234"))
		{
			session.setAttribute("user_id", id);
			session.setAttribute("user_pw", pw);
			out.print("세션 설정 완료"+"<br>");
			out.print(id+"님 환영합니다.");
		}
		else
		{
			out.print("세션 설정 실패"+"<br>");
		}
	%>
</body>
</html>