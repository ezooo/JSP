package controller;

import java.io.IOException;

import dao.member_repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class mb_cont3_delete extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("삭제 컨트롤 진입");
		//전처리
		String id = req.getParameter("id");
		
		//model
		member_repository mr = member_repository.getInstance();
		mr.deleteuser(id);
		
		//view
		//보여줄 뷰 없음 : 그럼 어디로 이동?
		resp.sendRedirect("readall");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
}
