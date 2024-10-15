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

@WebServlet("/book")
public class movebook extends HttpServlet
{           
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		bookRepository br = bookRepository.getRepository();
		req.setAttribute("br", br);
		
		RequestDispatcher ds = req.getRequestDispatcher("book.jsp");
		ds.forward(req, resp);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
}
 