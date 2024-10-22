<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<%@ page import="dao.bookRepository" %>

<!-- 저장소객체생성 할 필요 없다 (컨트롤러에서 이미 저장소를 req에 실어보내줬음) -->
<%
	ArrayList<Book> listOfBooks =(ArrayList<Book>) request.getAttribute("array"); //get 만났다 --> 변수에 넣기
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
		<header class="pb-3 mb-4 border-bottom">
			<a href="./welcome.jsp" class="d-flex aling-items-center text-dark text-decoration-none">
				<svg  width="32" height="32" fill="currentColor" class="bi bi-house-fill" viewBox="0 0 16 16">
              		<path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L8 2.207l6.646 6.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5Z"/>
              		<path d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6Z"/>
        		</svg>
        		<span class="fs-4">Home</span>
        		
			</a>
			<div class="d-flex aling-items-center">
				<span> &emsp; &emsp; &emsp; &emsp; &emsp;</span>
				<span><a href="products" class="text-dark text-decoration-none">도서 목록 보기 &emsp;</a></span>
				<span><a href="add_control" class="text-dark text-decoration-none"> 도서 등록</a></span>
				<!-- href 주소에 슬래쉬(/)를 붙이면 '절대경로로 경로를 표시하겠다'는 것 -->
			</div>
		</header>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서목록</h1>
				<p class="col-md-8 fs-4">BookList</p>
			</div>
		</div>	
		<%
			//bookRepository dao = bookRepository.getRepository();
			//ArrayList<Book> listOfBooks = dao.getAllBooks(); 위에 이미 연결됨
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
					<%= book.getFilename()%>
					
					<img src="./resource/images/<%=book.getFilename()%>" style="width : 250; height : 350" />
					<h5><b> <%=book.getName()%></b></h5>
					<p> <%=book.getAuthor()%></p>
					<br> <%=book.getPublisher()%> | <%=book.getUnitPrice()%>원
					<p> <%= book.getDescription() %></p>
					<p> <%=book.getReleaseDate()%> </p>
					<p> <%=book.getUnitPrice()%> </p>
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