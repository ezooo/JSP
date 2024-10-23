package controller;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/shipping")
public class shipping extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds=req.getRequestDispatcher("shipping.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setCharacterEncoding("UTF-8");
		
		Cookie cartId = new Cookie( "ship_cartId", URLEncoder.encode(req.getParameter("cartId"), "utf-8") );
		Cookie name = new Cookie( "ship_name", URLEncoder.encode(req.getParameter("name"), "utf-8") );
		Cookie shippingDate = new Cookie( "ship_shippingDate", URLEncoder.encode(req.getParameter("shippingDate"), "utf-8") );
		Cookie country = new Cookie( "ship_country", URLEncoder.encode(req.getParameter("country"), "utf-8") );
		Cookie zipCode = new Cookie( "ship_zipCode", URLEncoder.encode(req.getParameter("zipCode"), "utf-8") );
		Cookie addressName = new Cookie( "ship_addressName", URLEncoder.encode(req.getParameter("addressName"), "utf-8") );
		
		cartId.setMaxAge(24*60*60);
		name.setMaxAge(24*60*60);
		shippingDate.setMaxAge(24*60*60);
		country.setMaxAge(24*60*60);
		zipCode.setMaxAge(24*60*60);
		addressName.setMaxAge(24*60*60);
		
		resp.addCookie(cartId);
		resp.addCookie(name);
		resp.addCookie(shippingDate);
		resp.addCookie(country);
		resp.addCookie(zipCode);
		resp.addCookie(addressName);
		
		resp.sendRedirect("orderConfirm");
	}
	
}
