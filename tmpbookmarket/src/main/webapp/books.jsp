<%@page import="com.oreilly.servlet.*"%>
<%@page import="com.oreilly.servlet.multipart.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<%@ page import="dao.bookRepository" %>

<!-- 저장소객체생성 할 필요 없다 (컨트롤러에서 이미 저장소를 req에 실어보내줬음) -->
<%

	ArrayList<Book> listOfBooks =(ArrayList<Book>)request.getAttribute("array"); //get 만났다 --> 변수에 넣기
%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"></link>
	<!-- 이거 링크 설정 안하니까 페이지 Run 했을 때 구동되지 않음 -->
<link rel="stylesheet" href="./resource/css/bootstrap.min.css"></link>
<title>도서 목록</title>
</head>
<body>
	<div class = "container py-4">
		<%@ include file="menu.jsp" %>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서목록</h1>
				<p class="col-md-8 fs-4">BookList</p>
			</div>
		</div>	
		<%
			
			
		%>
		
		<div class="row align-items-md-stretch text-center">
			<%
			for(int i=0; i<listOfBooks.size(); i++)
					{
						Book book = listOfBooks.get(i);
						
					//이 for구조 뷰에서 아주아주아주 중요함
			%>
			<div class="col-md-4">
				<div class="h-100 p-2">					
					<img src="./resource/images/<%=book.getFilename()%>" style="width:250px; height:350px" />
					<h5><b> <%=book.getName()%></b></h5>
					<p> <%=book.getAuthor()%></p>
					<br> <%=book.getPublisher()%> | <%=book.getUnitPrice()%>원
					<p> <%= book.getDescription() %></p>
					<p> <%=book.getReleaseDate()%> </p>
					<p> <%=book.getCategory()%> | <%=book.getCondition()%> </p>
					<p> <a href="book?id=<%= book.getBookId() %>" class="btn btn-secondary" role="button">상세 정보 &raquo;</a> </p>
				</div>
			</div>
			<%
					} //for문 여기서 닫아야 함
			%>
		</div>
		<%@ include file = "footer.jsp"%>
	</div>
</body>
</html>