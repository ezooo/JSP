package chapter12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/12_2_filter")
public class exam12_2_filter extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("12_2_filter post");
		//전처리 - 파라미터 받기
		String id=req.getParameter("id");
		String passwd=req.getParameter("passwd");
		
		//받은거 담기
		req.setAttribute("id", id);
		req.setAttribute("password", passwd);
		
		//이동
		RequestDispatcher ds = req.getRequestDispatcher("chapter12/filter02.jsp");
		ds.forward(req, resp);
	}

}
