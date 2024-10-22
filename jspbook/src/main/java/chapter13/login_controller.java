package chapter13;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/13")
public class login_controller extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/login.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("login post");
		//전처리
		String id = req.getParameter("id");
		String password = req.getParameter("pw");
		
		if(id.equals("admin")&&password.equals("1234"))
		{	//컨트롤에서 세션 생성하는 방법 : 리퀘스트에게 달라고 함
			HttpSession session = req.getSession(true);	//세션생성
			//getSession(true) 혹은 getSession() : 현재 세션 객체가 있으면 그냥 쓰고 없으면 새로 생성함
			//getSession(false) : 현재 세션 객체가 있으면 그냥 쓰고 없으면 null 반환함
			session.setAttribute("id", id);
			session.setAttribute("pw", password);
			
			RequestDispatcher ds = req.getRequestDispatcher("chapter13/printer.jsp");
			ds.forward(req, resp);
		}
		else
		{
			
		}
		//모델
		//이동
	}
	
}
