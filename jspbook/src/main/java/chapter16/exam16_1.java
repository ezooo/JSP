package chapter16;

import java.io.IOException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/16_1")
public class exam16_1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16_1.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	//목표 : INSERT
		System.out.println("exam16_1 doPost");
		//전처리
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
			//받았으면 묶음으로 넘겨줄 것 : dto 만들자
		DTO16_1 dto = new DTO16_1();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		//묶었으면 repository 에 저장
			//repository 만들기
		DAO16_1 dao = DAO16_1.getInstance();
		dao.member_create(dto);
		//여기까지 하고 db 연결 확인하고 진행할 것	
	}
}
