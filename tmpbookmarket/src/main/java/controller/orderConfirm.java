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

@WebServlet("/orderConfirm")
public class orderConfirm extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("주문확인");
		//전처리
		req.setCharacterEncoding("UTF-8");
		
		HttpSession ssn = req.getSession(false);	//false
		String cartId = ssn.getId();
		
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
				if(n.equals("ship_name"))
				{
					ship_name=URLDecoder.decode(thisCookie.getValue(), "utf-8");
				}
				if(n.equals("ship_shippingDate"))
				{
					ship_shippingDate=URLDecoder.decode(thisCookie.getValue(), "utf-8");
				}
				if(n.equals("ship_country"))
				{
					ship_country=URLDecoder.decode(thisCookie.getValue(), "utf-8");
				}
				if(n.equals("ship_zipCode"))
				{
					ship_zipCode=URLDecoder.decode(thisCookie.getValue(), "utf-8");
				}
				if(n.equals("ship_addressName"))
				{
					ship_addressName=URLDecoder.decode(thisCookie.getValue(), "utf-8");	
				}
			}
		}
		
		//jsp에 가서 이 변수들 쓰려면 또 담아서 보내야 함
		req.setAttribute("ship_cartId", ship_cartId);
		req.setAttribute("ship_name", ship_name);
		req.setAttribute("ship_shippingDate", ship_shippingDate);
		req.setAttribute("ship_country", ship_country);
		req.setAttribute("ship_zipCode", ship_zipCode);
		req.setAttribute("ship_addressName", ship_addressName);
		
		RequestDispatcher ds = req.getRequestDispatcher("orderConfirm.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
