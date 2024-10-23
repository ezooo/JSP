package chapter14;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/14_1")
public class exam14_1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter14/exam14_1.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("14_1 post");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		if(id.equals("admin")&&pw.equals("1234"))
		{
			Cookie ckId = new Cookie("id",id);
			Cookie ckPw = new Cookie("pw",pw);
			resp.addCookie(ckId);
			resp.addCookie(ckPw);
			System.out.println("쿠키 생성 성공");
		}
		else
		{
			System.out.println("쿠기 생성 실패");
		}
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter14/exam14_1_print.jsp");
		ds.forward(req, resp);
	}

}
