<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Book" %>
<%@ page import="dao.bookRepository" %>
<%@ page errorPage="exceptionNoBookId.jsp" %>
<!-- 객체 생성 할 필요없다 컨트롤러가 해줌
<jsp:useBean id="bookDAO" class="dao.bookRepository" scope="session"></jsp:useBean>
 -->
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"></link>
<link rel="stylesheet" href="./resource/css/bootstrap.min.css"></link>
<meta charset="UTF-8">
<title>도서 상세 정보</title>
</head>
<body>
	<div class="container py-4">
		<%@ include file="menu.jsp" %>
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서정보</h1>
				<p class="col-md-8 fs-4">BookInfo</p>
			</div>
		</div>

		<%
			String id = request.getParameter("id");
			//Book book = bookDAO.getBookById(id);
			bookRepository br = (bookRepository)request.getAttribute("br");
			//bookRepository dao = bookRepository.getInstance();
			Book book = br.getBookById(id);
		%>
		
		<div class="row aligh-items-md-stretch">
			<div class="col-md-5">
				<img src="./resource/images/<%=book.getFilename()%>" style="width : 70%" />
			</div>
			<div class="col-md-6">
				<h3><b><%=book.getName() %></b></h3>
				<p><%=book.getDescription() %> </p>
				<p> <b>도서코드</b> : <span class="badge text-bg-danger"><%= book.getBookId()%></span></p>
				<p> <b>저자</b> : <%=book.getAuthor() %> </p>
				<p> <b>출판사</b> : <%=book.getPublisher() %> </p>
				<p> <b>출판일</b> : <%=book.getReleaseDate() %> </p>
				<p> <b>분류</b> : <%=book.getCategory() %> </p>
				<p> <b>재고 수</b> : <%=book.getUnitsInStock() %> </p>
				<h4><%= book.getUnitPrice() %>원</h4>
				<p> <a href="#" class="btn btn-info">도서주문 &raquo;</a></p>
				<a href="products" class="btn btn-secondary">도서목록 &raquo;</a>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>