<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<%@ page import="dao.bookRepository" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tmpbookmarket/resource/css/bootstrap.min.css"></link>
<title>주문 정보</title>
</head>
<body>
<%
	String ship_cartId = (String)request.getAttribute("ship_cartId");
	String ship_name = (String)request.getAttribute("ship_name");
	String ship_shippingDate = (String)request.getAttribute("ship_shippingDate");
	String ship_country = (String)request.getAttribute("ship_country");
	String ship_zipCode = (String)request.getAttribute("ship_zipCode");
	String ship_addressName = (String)request.getAttribute("ship_addressName");
%>
	<div class="container py-4">
		<%@ include file="menu.jsp" %>
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">주문 정보</h1>
				<p class="col-md-8 fs-4">Order Info</p>
			</div>
		</div>

		<div class="row aligh-items-md-stretch alert alert-info">
			<div class="text-center">
				<h1>영수증</h1>
			</div>
			<div class="row justify-content-between">
				<div class="col-4" align="right">
					<strong>배송 주소</strong> <br> 
					성  명 : <% out.println(ship_name); %> <br>
					우편번호 : <% out.println(ship_zipCode); %> <br>
					주  소 : <% out.println(ship_addressName); %> <br>
				</div>
				<div class="col-4" align="right">
					<p><em>배송일 : <% out.println(ship_shippingDate); %></em></p>
				</div>
			</div>
			<div class="py-5">
				<table class="table table-hover">
					<tr>
						<th class="text-center">도서</th>
						<th class="text-center">수량</th>
						<th class="text-center">가격</th>
						<th class="text-center">소계</th>
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
						<td class="text-center"><em><%= book.getName() %></em></td>
						<td class="text-center"><%= book.getQuantity() %></td>
						<td class="text-center"><%= book.getUnitPrice() %>원</td>
						<td class="text-center"><%= total %>원</td>
					</tr>
					<%
						}
					%>
					<tr>
						<td></td>
						<td></td>
						<td class="text-right"><strong>총액: </strong></td>
						<td class="text-center"><strong><%= sum %></strong></td>
					</tr>
				</table>
				<a href="shipping?cartId=<%= ship_cartId %>" class="btn btn-secondary" role="button">이 전</a>
				<a href="thanks" class="btn btn-success" role="button">주문 완료</a>
				<a href="cancel" class="btn btn-secondary" role="button">취 소</a>
			</div>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>