<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="8_4" id="form" method="post">
		<p> 아이디 : <input type="text" name="id" id="id"> </p>
		<p> 비밀번호 : <input type="password" name="password" id="password"> </p>
		<p> 이 름 : <input type="text" name="name" id="name"> </p>
		<p> <input type="button" value="전송" id="btn"> </p>
	</form>
</body>
<script type="text/javascript">
	//변수, 이벤트
	let btn = document.querySelector("#btn");
	console.log(btn);
	btn.addEventListener("click", logIn);
	
	function logIn()
	{
		console.log("function connect");
		//form 연결
		let form = document.querySelector("form");
		//아이디는 영문소문자만 가능
		let id = document.querySelector("#id").value;
		for(let i=0; i<id.length; i++)
		{
			//한글자씩 잘라와서 검사하기
			let ch = id.charAt(i);
			console.log(i+"번째 ch : "+ch);
			
			if( (ch<'a'||ch>'z')&&(ch>'A'||ch<'Z')&&(ch>'0'||ch<'9') )
			{
				alert("아이디는 영문 소문자만 입력 가능");
				form.id.select();
				return;
			}
		}
		//비밀번호는 숫자만
		let password = document.querySelector("#password").value;
		if(isNaN(password))
		{
			alert("비밀번호는 숫자만 입력 가능");
			form.password.select();
			return;
		}
		form.submit();
	}
</script>
</html>