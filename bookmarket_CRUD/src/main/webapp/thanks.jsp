<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 완료</title>
<link rel="stylesheet" href="/bookmarket_CRUD/resources/css/bootstrap.min.css"></link>
</head>
<body>
<%
	String ship_cartId = (String)request.getAttribute("ship_cartId");
	String ship_shippingDate = (String)request.getAttribute("ship_shippingDate");
	System.out.println(ship_cartId);
%>
<div class="container py-4">
	<%@ include file="menu.jsp" %>
	<div class="p-5 mb-4 bbg-body-tertiary rounded-3">
		<div class="container-fluid py-5">
			<h1 class="display-5 fw-bold">주문 완료</h1>
			<p class="col-md-8 fs-4">Order Completed</p>
		</div>
	</div>
	
	<div class="row align-items-md-stretch">
		<h2 class="alert alert-danger">주문해주셔서 감사합니다.</h2>
		<p>주문은 <% out.println(ship_shippingDate); %>에 배송될 예정입니다!</p>
		<p>주문번호 : <% out.println(ship_cartId); %></p>
	</div>
	<div>
		<p><a href="books" class="btn btn-secondary">도서목록 &raquo;</a></p>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
