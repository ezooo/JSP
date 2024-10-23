package controller;

import java.io.IOException;
import java.net.URLDecoder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/thanks")
public class thanks extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("주문완료 컨트롤");
		String ship_cartId="";
		String ship_name="";
		String ship_shippingDate="";
		String ship_country="";
		String ship_zipCode="";
		String ship_addressName="";
		
		Cookie[] cookies = req.getCookies();
		
		if(cookies!=null)
		{
			for(int i=0; i<cookies.length; i++)
			{
				Cookie thisCookie = cookies[i];
				String n = thisCookie.getName();
				
				if(n.equals("ship_cartId"))
				{
					ship_cartId=URLDecoder.decode(thisCookie.getValue(), "utf-8");	//키 매칭해서 맞으면 쿠키의 값을 가져와서 대입
				}
				if(n.equals("ship_shippingDate"))
				{
					ship_shippingDate=URLDecoder.decode(thisCookie.getValue(), "utf-8");
				}
			}
		}
		
		req.setAttribute("ship_cartId", ship_cartId);
		req.setAttribute("ship_shippingDate", ship_shippingDate);
		
		//세션삭제
		HttpSession ssn = req.getSession(false);
		ssn.invalidate();
		//쿠키삭제
		for(int i=0; i<cookies.length; i++)
		{
			Cookie thisCookie = cookies[i];
			String n = thisCookie.getName();
			
			if(n.equals("ship_cartId"))
			{
				thisCookie.setMaxAge(0);
			}
			if(n.equals("ship_name"))
			{
				thisCookie.setMaxAge(0);
			}
			if(n.equals("ship_shippingDate"))
			{
				thisCookie.setMaxAge(0);
			}
			if(n.equals("ship_country"))
			{
				thisCookie.setMaxAge(0);
			}
			if(n.equals("ship_zipCode"))
			{
				thisCookie.setMaxAge(0);
			}
			if(n.equals("ship_addressName"))
			{
				thisCookie.setMaxAge(0);	
			}
			resp.addCookie(thisCookie);
		}

		
		RequestDispatcher ds = req.getRequestDispatcher("thanks.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
