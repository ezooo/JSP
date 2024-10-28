package chapter16;

import java.io.IOException;

import dao.DAO3;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/16_5")
public class exam16_5 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("select doGet");
		//전처리 : db의 내용을 가져와서 뷰에 넘겨줘야 함
		DAO3 dao = DAO3.getInstance();
		//dao.member_readall();	//얘가 arr 돌려줌
		//이걸 req에 실어보내야 함
		req.setAttribute("arr", dao.member_readall());
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16_5.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
