<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.bookRepository" %>
<%@ page import="dto.Book" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 편집</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	function deleteConfirm(id)
	{
		if( confirm("선택한 도서를 삭제합니다")==true )
		{
			location.href="deleteBook?id="+id;
		}
		else
		{
			return;
		}
	}
</script>
</head>
<body>
<%
	ArrayList<Book> arr = (ArrayList<Book>)request.getAttribute("array");
%>
<div class="container py-4">
	<%@ include file="menu.jsp" %>
	<div class="p-5 mb-4 bbg-body-tertiary rounded-3">
		<div class="container-fluid py-5">
			<h1 class="display-5 fw-bold">도서 편집</h1>
			<p class="col-md-8 fs-4">Book Editing</p>
		</div>
	</div>
	
	<div class="row aligh-items-md-stretch">
		<%
			for(int i=0; i<arr.size(); i++)
					{
						Book book = arr.get(i);
						
					//이 for구조 뷰에서 아주아주아주 중요함
		%>
		<div class="col-md-4">
			<div class="h-100 p-2 round-3">
				<img src="./resource/images/<%=book.getFilename()%>" style="width : 70%" />
				<p> <b>도서코드</b> : <span class="badge text-bg-danger"><%= book.getBookId()%></span></p>
				<h3><b><%=book.getName() %></b></h3>
				<p> <b>저자</b>  <%=book.getAuthor() %> </p>
				<p> <b>출판사</b>  <%=book.getPublisher() %> </p>
				<p> <b>출판일</b>  <%=book.getReleaseDate() %> </p>
				<p> <b>설명</b> <%=book.getDescription() %> </p>
				<p> <b>가격</b> <%= book.getUnitPrice() %>원</p>
				<p> <b>분류</b>  <%=book.getCategory() %> </p>
				<p> <b>재고 수</b>  <%=book.getUnitsInStock() %> </p>
				<p>	
					<a href="updateBook?id=<%= book.getBookId() %>" class="btn btn-secondary">수정 &raquo;</a>
					<a href="#" class="btn btn-danger" role="button" onclick="deleteConfirm('<%= book.getBookId() %>')">삭제 &raquo;</a>
				</p>
			</div>
		</div>
		<%
					} //for문 여기서 닫아야 함
		%>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>

</html>