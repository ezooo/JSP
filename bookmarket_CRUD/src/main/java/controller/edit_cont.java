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

@WebServlet("/edit")
public class edit_cont extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("edit doget");
		//전처리
		String edit = req.getParameter("edit");
		
		//모델이동
		bookRepository br = bookRepository.getRepository();
		ArrayList<Book> arr =br.getAllBooks();
		
		//뷰이동
		req.setAttribute("arr", arr);
		req.setAttribute("edit", edit);	//이것도 가져가야 if 결정할 수 있음
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
