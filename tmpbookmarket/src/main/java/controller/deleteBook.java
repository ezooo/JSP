package controller;

import java.io.IOException;

import dao.bookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteBook")
public class deleteBook extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	//선택한 책 아이디 가져와서 해당 아이디 db에서 삭제하기
		System.out.println("deleteBook doget");
		//전처리
		String bookid = req.getParameter("id");
		//모델이동
		bookRepository br = bookRepository.getRepository();
		br.deleteBook(bookid);
		//뷰이동
		//딱히 리턴없음
		resp.sendRedirect("products");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}

}
