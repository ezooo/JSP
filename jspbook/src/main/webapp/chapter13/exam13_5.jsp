<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>--------- 세션 삭제 전 ---------</h4>
	<%
		//Enumeration 이용해서 출력하기
		//키 값들 가져와서 담을 변수 선언해놓기
		String name;
		String value;
		//키 목록 달라고하기
		Enumeration en = session.getAttributeNames();
		int i=0; //그냥 몇 번째 속성인지 세려고 하는거
		//하나씩 꺼내서 출력하기
		while(en.hasMoreElements())	//요소를 더 가지고 있다면 true
		{
			i++;
			//목록에서 키 하나씩 꺼내서 담을 거
			name = en.nextElement().toString();	//세션도 리퀘스트와 마찬가지로 형변환해서 담아야 함
			//이건 키 꺼내서 name에 담은거 -- 이제 키 이름 아니까 값도 꺼낼 수 있음
			value = (String)session.getAttribute(name);	//toString() 안쓰고 그냥 캐스팅해도 됨
			//Enumeration 에는 키 목록만 있다. 값 달라고 할때는 세션한테 가서 달라고 해야 함
			//출력해보기
			out.println("설정된 세션의 속성 이름 ["+i+"] : "+ name +"<br>");
			out.println("설정된 세션의 속성 값 ["+i+"] : "+ value +"<br>");
		}
		
		//세션 속성 삭제하기
		session.removeAttribute("user_id");	//세션 생성을 예제13_1 가지고 할 거..
		//13_1 에서 세션한테 set 해줄 때 사용한 키가 user_id
	%>
	<h4>--------- 세션 삭제 후 ---------</h4>
	<%
		en = session.getAttributeNames();
		i=0;
		while(en.hasMoreElements())
		{
			i++;
			name = en.nextElement().toString();
			value = session.getAttribute(name).toString();
			out.println("설정된 세션의 속성 이름 ["+i+"] : "+ name +"<br>");
			out.println("설정된 세션의 속성 값 ["+i+"] : "+ value +"<br>");
		}
	%>
</body>
</html>