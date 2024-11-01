<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<fmt:setLocale value='<%= request.getParameter("language") %>'></fmt:setLocale>
<fmt:bundle basename="bundle.message">

<div class="container py-4">
	<%@ include file="menu.jsp" %>
	<div class="p-5 mb-4 bbg-body-tertiary rounded-3">
		<div class="container-fluid py-5">
			<h1 class="display-5 fw-bold"><fmt:message key="title" /></h1>
			<p class="col-md-8 fs-4">Book Addition</p>
		</div>
	</div>
	
	<div class="row align-items-md-stretch">
		<div class="text-end">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
			<a href="?language=ko" class="text-dark text-decoration-none">Korean</a>
			 | <a href="?language=en" class="text-dark text-decoration-none">English</a>
			<a href="logout.jsp" class="btn btn-sm btn-success pull right">logout</a>
		</div>
		<form action="addBook" method="post" enctype="multipart/form-data" class="form-horizontal" id="addForm">
		<!-- 이미지 파일이 섞이게 되면서 멀티파트 사용하도록 바뀜 -->
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="bookId" /></label>
				<div class="col-sm-3">
					<input type="text" name="bookId" class="form-control" id="bookId">
					<!-- 유효성 검사 함수와 연결하기 위해 아이디 설정 -->
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="name" /></label>
				<div class="col-sm-3">
					<input type="text" name="name" class="form-control" id="name">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="unitPrice" /></label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" class="form-control" id="unitPrice">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="author" /></label>
				<div class="col-sm-3">
					<input type="text" name="author" class="form-control">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="publisher" /></label>
				<div class="col-sm-3">
					<input type="text" name="publisher" class="form-control">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="releaseDate" /></label>
				<div class="col-sm-3">
					<input type="text" name="releaseDate" class="form-control">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="description" /></label>
				<div class="col-sm-8">
					<textarea name="description" cols="100" rows="5" class="form-control" id="description"></textarea>
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="category" /></label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="unitsInStock" /></label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStock" class="form-control" id="unitsInStock">
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="condition" /></label>
				<div class="col-sm-5">
					<input type="radio" name="condition" value="New"><fmt:message key="condition_New" />
					<input type="radio" name="condition" value="Old"><fmt:message key="condition_Old" />
					<input type="radio" name="condition" value="EBook"><fmt:message key="condition_Ebook" />
				</div>
			</div>
			<div class="mb-3 row">
				<label class="col-sm-2"><fmt:message key="bookImage" /></label>
				<div class="col-sm-8">
					<input type="file" name="bookImage" class="form-control">
					<!-- 이미지를 위한 div 추가 -->
				</div>
			</div>
			<div class="mb-3 row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-primary" value="<fmt:message key="button" />" id="btn">
					<!-- type이 submit이면 무조건 제출해버리기 때문에 버튼타입으로 할 것 -->
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>

</fmt:bundle>
</body>

<!-- 유효성 검사 -->
<script type="text/javascript">
	//버튼 클릭 시 유효성 검사 이벤트 발생
	let btn = document.querySelector("#btn");
	console.log(btn);	//콘솔 잘 찍자
	btn.addEventListener("click", checkAddBook);
	
	
	//유효성 검사 함수
	function checkAddBook()
	{
		console.log("checkAddBook start");
		let addForm = document.querySelector("#addForm");
		//검사항목 : 도서코드 ISBN으로 시작하는지 / 도서명 2-20자 / 도서가격 숫자만 / 재고 수 숫자만 / 상세설명 100자 이상
		//도서코드 검사
		let bookId = document.querySelector("#bookId");
		let msg = "[도서코드]\n ISBN과 숫자를 조합하여 5~12자까지 입력하세요.\n 첫 글자는 반드시 ISBN으로 시작하세요.";
		if( !check(/^ISBN[0-9]{4,11}$/, bookId, msg) )	//ISBN 뒤에 0-9까지 숫자가 오는데 4~11개 올 수 있다(반복할 수 있다)
		{
			return false;
		}
		//도서명 검사
		let name = document.querySelector("#name").value;
		if( name.length<2 || name.length>20 )	//
		{	
			alert("[도서명]\n 2-20자를 입력하세요.");
			name.focus;
			return false;
		}
		
		//제출
		addForm.submit();
	}
	
	//유효성검사 - 체크하고 메시지 반환하는 함수
	function check(regExp, e, msg)
	{
		console.log("check start");
		if(regExp.test(e.value))	//test: 매개변수 값으로 전달되는 문자열이 정규 표현식에 부합한지 판단해서 true false 반환
		{
			return true;
		}
		alert(msg);
		e.focus;
		return false;
	}
</script>

</html>