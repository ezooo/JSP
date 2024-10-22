package chapter11;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/11_4")
public class exam11_4 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("11_4 doget");
		RequestDispatcher ds = req.getRequestDispatcher("chapter11/exam11_4.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("11_4 dopost");
		
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num2);
		int c = a/b;
		System.out.println("결과 : " +num1 + "/" +num2 + " = "+c);
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter11/errorCode.jsp");
		ds.forward(req, resp);
	}

}
