<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>param action tag</h3>
	<jsp:include page="param02_1_data.jsp">
		<jsp:param name="22" value='<%= java.net.URLEncoder.encode("오늘의 날짜와 시각") %>'></jsp:param>
		<jsp:param name="date" value='<%= java.util.Calendar.getInstance().getTime() %>'></jsp:param>
	</jsp:include>
</body>
</html>