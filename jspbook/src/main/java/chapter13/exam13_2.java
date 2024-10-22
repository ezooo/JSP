package chapter13;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/13_2")
public class exam13_2 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_2.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("13_2 post");
		//전처리
		//일단 파라미터 받기
		String id = req.getParameter("id");
		String password = req.getParameter("passwd");	//폼에서 넘겨준 키 값으로 파라미터 받기
		//검사	-- 아이디 패스워드가 맞으면 세션 만들어줌
		if(id.equals("admin") && password.equals("1234"))
		{
			//세션 생성 : 리쿼스트에게 달라고 하기. 세션의 데이터 타입은 HttpSession
			HttpSession ssn = req.getSession(true);
			//세션 객체 만들었으면 세션에 set 하기
			ssn.setAttribute("log_id", id);
			ssn.setAttribute("log_pw", password);
			
			System.out.println("세션 설정 완료");
			String msg = id+"님 환영합니다!";
			System.out.println(msg);
			ssn.setAttribute("message", msg);
		}
		else
		{
			System.out.println("세션 설정 실패");
		}
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_2_print.jsp");
		ds.forward(req, resp);
	}

}
