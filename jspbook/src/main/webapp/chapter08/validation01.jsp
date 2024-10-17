<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" action="#" method="get">
	<!-- onclick 으로 이벤트 주기
		<p> 아이디 : <input type="text" name="id"> </p>
		<p> 비밀번호 : <input type="password" name="passwd"> </p>
		<p> <input type="submit" value="전송" onclick="checkForm()"> </p>
	 -->
		
		<p> 아이디 : <input type="text" name="id" id="id"> </p>
		<p> 비밀번호 : <input type="password" name="passwd" id="passwd"> </p>
		<p> <input type="submit" value="전송" id="submit"> </p>
	</form>
</body>
<script type="text/javascript">
	var submit = document.querySelector("#submit");
	submit.addEventListener("click",checkForm);

	function checkForm()
	{
		var id = document.querySelector("#id").value;
		console.log(id);
		var passwd = document.querySelector("#passwd").value;
		alert("아이디 : "+ id + "\n"
				+ "비밀번호 : "+ passwd);
	}
</script>
</html>