<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<%@ page import="dao.bookRepository" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/bookmarket_CRUD/resources/css/bootstrap.min.css"></link>
<%
	HttpSession session = request.getSession(false);	
	String cartId = session.getId();
%>
<title>장바구니</title>
</head>

<body>
	<div class="container py-4">
		<%@ include file="menu.jsp" %>
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">장바구니</h1>
				<p class="col-md-8 fs-4">Cart</p>
			</div>
		</div>

		<div class="row aligh-items-md-stretch">
			<div class="row">
				<table width="100%">
					<tr>
						<td align="left"><a href="deleteCart?cartId=<%=cartId %>" class="btn btn-danger">삭제하기</a></td>						
						<td align="right"><a href="shipping?cartId=<%=cartId %>" class="btn btn-success">주문하기</a></td>
					</tr>
				</table>
			</div>
			<div style="padding-top: 50px">
				<table class="table table-hover">
					<tr>
						<th>도서</th>
						<th>가격</th>
						<th>수량</th>
						<th>소계</th>
						<th>비고</th>
					</tr>
					<%
						int sum=0;
						ArrayList<Book> cartlist=(ArrayList<Book>)session.getAttribute("cartlist");
						if(cartlist==null)
						{
							cartlist=new ArrayList<Book>();
						}
						for(int i=0; i<cartlist.size(); i++)
						{
							Book book = cartlist.get(i);
							int total = book.getUnitPrice()*book.getQuantity();
							sum=sum+total;	
					%>
					<tr>
						<td><%= book.getBookId() %> - <%= book.getName() %></td>
						<td><%= book.getUnitPrice() %></td>
						<td><%= book.getQuantity() %></td>
						<td><%= total %></td>
						<td><a href="./removeCart.jsp?id=<%=book.getBookId() %>" class="badge text-bg-danger">삭제</a></td>
					</tr>
					<%
						}
					%>
					<tr>
						<th></th>
						<th></th>
						<th>총액</th>
						<th><%= sum %></th>
						<th></th>
					</tr>
				</table>
				<a href="books" class="btn btn-secondary"> &laquo; 쇼핑 계속하기</a>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>