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
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("id");
		String password = request.getParameter("passwd");
		String username = request.getParameter("name");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String usersex = request.getParameter("sex");
		String[] hobby = request.getParameterValues("hobby");

	%>
	<p> 아 이 디 : <%= userid %> </p>
	<p> 비밀번호 : <%= password %> </p>
	<p> 이 름 : <%= username %> </p>
	<p> 연락처 : <% out.print(phone1+"-"+phone2+"-"+phone3); %> </p>
	<p> 성 별 : <%= usersex %> </p>
	<p> 취 미 : 
		<% 
			if(hobby != null)
			{
				for(int i=0; i<hobby.length; i++)
				{
					out.print(" "+hobby[i]); 
				}
			}
		%> 
	</p>
</body>
</html>