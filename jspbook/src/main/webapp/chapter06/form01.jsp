<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원 가입</h3>
	<form action="6_1" method="post">
		<p> 아이디 : <input type="text" name="id"> <input type="button" value="아이디 중복 검사"> </p>
		<p> 비밀번호 : <input type="password" name="passwd"> </p>
		<p> 이름 : <input type="text" name="name"> </p>
		<p> 연락처 : 
			<select name="phone1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="019">019</option>
			</select>			 
			- <input type="text" name="phone2" maxlength="4" size="4">
			- <input type="text" name="phone3" maxlength="4" size="4">
		</p>
		<p> 성별 : <input type="radio" name="sex" value="남성" checked>남성
			<input type="radio" name="sex" value="여성">여성 
		</p>
		<p> 취미 : 독서<input type="checkbox" name="hobby" value="독서" checked>
			운동<input type="checkbox" name="hobby" value="운동">
			영화<input type="checkbox" name="hobby" value="영화">
		</p>
		<p>
			<textarea name="comment" rows="3" cols="30" placeholder="가입 인사 입력"></textarea>
		</p>
		<p> <input type="submit" value="가입하기"> 
			<input type="reset" value="다시 쓰기">
		</p>
	</form>
</body>
</html>