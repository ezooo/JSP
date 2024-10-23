<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resource/css/bootstrap.min.css"></link>
<title>주문 취소</title>
</head>
<body>
<div class="container py-4">
	<%@ include file="menu.jsp" %>
	<div class="p-5 mb-4 bbg-body-tertiary rounded-3">
		<div class="container-fluid py-5">
			<h1 class="display-5 fw-bold">주문 취소</h1>
			<p class="col-md-8 fs-4">Order Cancellation</p>
		</div>
	</div>
	
	<div class="row align-items-md-stretch">
		<h2 class="alert alert-danger">주문이 취소되었습니다.</h2>
	</div>
	<div class="container">
		<p><a href="products" class="btn btn-secondary">도서목록 &raquo;</a></p>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>