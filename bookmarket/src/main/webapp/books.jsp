<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.book" %>
<jsp:useBean id="bookdao" class="dao.bookRepository" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class = "container py-4">
		<%@ include file = "menu.jsp" %>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1>도서목록</h1>
				<p>BookList</p>
			</div>
		</div>
		
		<% ArrayList<book> listOfBooks = bookdao.getAllBooks(); %>
		
		<div>
			<% %>
			<div>
				<div>
					<h5></h5>
					<p></p>
					<br>
					<p></p>
					<p></p>
				</div>
			</div>
			<%
			
			%>
		</div>
		<%@ %>
	</div>
</body>
</html>