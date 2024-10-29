package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.bookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editBook")
public class editBook extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("editbook doget");
		//전체책 목록 가지고 가야 함
		bookRepository br = bookRepository.getRepository();
		ArrayList<Book> arr =br.getAllBooks();
		req.setAttribute("array", arr);
		
		RequestDispatcher ds = req.getRequestDispatcher("editBook.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
