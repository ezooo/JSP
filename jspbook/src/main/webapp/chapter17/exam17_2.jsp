<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exam17_2.jsp</title>
</head>
<body>
<%
	String num = (String)request.getAttribute("num");
%>

	<c:set var="number" value="<%= num %>"></c:set>
	<br>
	<c:choose>
		<c:when test="${number%2==0}">
			<c:out value="${number}"></c:out>은 짝수입니다.
		</c:when>
		<c:when test="${number%2==1}">
			<c:out value="${number}"></c:out>은 홀수입니다.
		</c:when>
		<c:otherwise>
			<c:out value="${number}"></c:out>은 숫자가 아닙니다.
		</c:otherwise>
	</c:choose>
	
	<br>
	<h3>구구단</h3>
	<table>
		<c:forEach var="i" begin="2" end="9">
			<tr>
				<c:forEach var="j" begin="1" end="9">
					<td width=100>
						${i}*${j}=${ i*j }
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>