package chapter16;

import java.io.IOException;

import dao.DAO3;
import dto.DTO3;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/16_3")
public class exam16_3 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16_3.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("exam16_3 doPost");
		//전처리
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
			//묶기
		DTO3 dto = new DTO3();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		
		DAO3 dao = DAO3.getInstance();
		dao.member_create(dto);
		
		//뷰 이동 -- select 실행하러가기
		resp.sendRedirect("16_5");
	}

}
