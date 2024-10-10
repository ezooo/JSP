package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// controller를 만드는 방법 순서대로 확인해보기
// step 1 : HttpServlet 클래스를 상속받음
// step 2 : 오버라이딩 실시 doGet(), doPost()
// step 3 : 서블릿매핑

@WebServlet("/first")  //step3
public class cont1 extends HttpServlet  //step1
{
	@Override  //step2
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("첫번째 doGet 실행됨");
		RequestDispatcher ds = req.getRequestDispatcher("first.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("doPost 실행");
	}
}
