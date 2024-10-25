package controller;

import java.io.IOException;

import dao.member_repository;
import dto.member_dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class mb_cont4_update extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("업데이트 컨트롤 진입");
		//전처리
		String id = req.getParameter("id");
		//모델 이동
		member_repository mr = member_repository.getInstance();
		member_dto dto = mr.getOnemember(id);	//받을 때 dto로 받아야 함
		//뷰 이동
		req.setAttribute("DTO", dto);
		RequestDispatcher ds = req.getRequestDispatcher("updateform.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("업데이트 컨트롤 post 함수진입");
		//전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		int age = Integer.parseInt(req.getParameter("age"));
		member_dto dto = new member_dto();
		dto.setId(id);
		dto.setPw(pw);
		dto.setAge(age);
		
		//모델
		member_repository mr = member_repository.getInstance();
		mr.update_member(dto);
		
		//뷰
		resp.sendRedirect("readall");
		//보여줄 뷰가 없음
	}
}
