<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.Book" %>
<%@ page import="dao.bookRepository" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id= request.getParameter("id");
if(id==null || id.trim().equals(""))
{
	response.sendRedirect("books.jsp");
	return;
}

bookRepository dao = bookRepository.getRepository();
Book book = dao.getBookById(id);
if(book==null)
{
	response.sendRedirect("exceptionNoBookId.jsp");	//수정가능한지 확인하기
}

ArrayList<Book> cartlist = (ArrayList<Book>)session.getAttribute("cartlist");
Book goodsQnt = new Book();
for(int i=0; i<cartlist.size(); i++)
{
	goodsQnt=cartlist.get(i);	//리스트에  담긴거 하나씩 꺼내서 유효성검사
	if(goodsQnt.getBookId().equals(id))
	{
		cartlist.remove(goodsQnt);
	}
}
response.sendRedirect("cart.jsp");
%>
</body>
</html>