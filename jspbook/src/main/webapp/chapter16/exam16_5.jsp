<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.DTO3" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
</head>
<body>
<%
	ArrayList<DTO3> arr = (ArrayList<DTO3>)request.getAttribute("arr");
%>
<table width="300px" border="1">
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
		<th></th>
		<th></th>
	</tr>
	<%
		for(int i=0; i<arr.size(); i++)
		{
			DTO3 dto = arr.get(i);
			String id = dto.getId();
			String pw = dto.getPw();
			String name = dto.getName();
		
	%>
	<tr>
		<td><%= id %></td>
		<td><%= pw %></td>
		<td><%= name %></td>
		<td><a href="update?id=<%=id%>">수정</a></td>
		<td><a href="delete?id=<%=id%>">삭제</a></td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>