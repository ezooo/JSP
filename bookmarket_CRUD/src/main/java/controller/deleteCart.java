package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteCart")
public class deleteCart extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("삭제하기 get");
		String id= req.getParameter("cartId");
		HttpSession ssn = req.getSession(false);
		if(id==null || id.trim().equals(""))
		{
			resp.sendRedirect("cart");
			return;
		}

		ssn.invalidate();
		resp.sendRedirect("cart");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
