<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resource/css/bootstrap.min.css"></link>
<title>페이지 오류</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class="jumbotron">
		<div class="container">
			<h2 class="alert alert-danger">요청하신 페이지를 찾을 수 없습니다.</h2>
		</div>
	</div>

	<div class="container">
		<p> <%= request.getRequestURI() %> </p>
		<p> <a href="books.jsp" class="btn btn-secondary">도서 목록 &raquo;</a> </p>
	</div>
</body>
</html>