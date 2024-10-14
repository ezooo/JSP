package chapter05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/5_4_1")
public class exam05_4_1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf8");
		String userid=request.getParameter("id");
		String password = request.getParameter("passwd");
		
		if(userid.equals("관리자") && password.equals("1234"))
		{
			response.sendRedirect("chapter05/response01_success.jsp");
		}
		else
		{
			response.sendRedirect("chapter05/response01_failed.jsp");
		}
	}
}
