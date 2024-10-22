<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	<%
	String name;
	String value;
	
	
	Enumeration en = session.getAttributeNames();	//가져올 속성 값이 여러 개 일때 혹은 이름을 모를 때
	int i=0;
	
	while(en.hasMoreElements())
	{
		i++;
		name = en.nextElement().toString();
		value = session.getAttribute(name).toString();	//이게 원래 하려던 것
		out.println("설정된 세션의 속성 이름 ["+i+"] : "+name);
		out.println("설정된 세션의 속성 값 ["+i+"] : "+value);
	}
	%>
</body>
</html>