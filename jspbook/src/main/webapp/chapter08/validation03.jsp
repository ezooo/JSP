<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="8_3" id="form" method="post">
		<p> 아이디 : <input type="text" name="id" id="id"> </p>
		<p> 비밀번호 : <input type="password" name="password" id="password"> </p>
		<p> 이 름 : <input type="text" name="name" id="name"> </p>
		<p> <input type="button" value="전송" id="btn"> </p>
	</form>
</body>
<script type="text/javascript">
	//변수 만들고 이벤트 할당하기
	let btn = document.querySelector("#btn");
	console.log(btn);
	btn.addEventListener("click", checkLogin);
	
	function checkLogin() //함수기능 : 아이디 길이설정 , 비밀번호 길이설정, 이름 숫자로 시작할수 없음
	{
		let form = document.querySelector("#form");
		//아이디 길이 설정 : 4~12자
		let id = document.querySelector("#id").value;
		console.log("아이디확인");
		if(id.length<4 || id.length>12)
		{
			alert("아이디는 4-12자 이내로 입력하세요.");
			form.id.select();
			return;
		}
		//비밀번호 길이 설정 : 4 이상
		let password = document.querySelector("#password").value;
		console.log("비밀번호확인")
		if(password.length<4)
		{
			alert("비밀번호는 4글자 이상 입력하세요.");
			form.password.select();
			return;
		}
		//이름이 숫자로 시작하는지 확인
		let name = document.querySelector("#name").value;
		console.log("name확인")
		if( !isNaN(name.substring(0,1)) )
		{
			alert("이름은 숫자로 시작할 수 없습니다.");
			form.name.select();
			return;
		}
		
		//폼 제출하기
		form.submit();
	}
</script>
</html>