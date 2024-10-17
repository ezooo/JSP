<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" action="8_2" method="post" id="form">
		<p> 아이디 : <input type="text" name="id" id="id"> </p>
		<p> 비밀번호 : <input type="password" name="passwd" id="passwd"> </p>
		<p> <input type="button" value="전송" id="btn"> </p>
	</form>
</body>
<script type="text/javascript">
	let btn = document.querySelector("#btn");
	console.log(btn);
	btn.addEventListener("click", checkLogin);
	
	function checkLogin()
	{
		console.log("gka");
		var id = document.querySelector("#id").value;
		var passwd = document.querySelector("#passwd").value;
		console.log(id);
		
		var form = document.querySelector("#form");

		if(id=="")
		{
			alert("아이디 입력하세요");
			form.id.focus();
			return false;
		}
		else if(passwd=="")
		{
			alert("비밀번호 입력하세요");
			form.passwd.focus();
			return false;
		}
		console.log("패스");
		form.submit();
	}
</script>
</html>