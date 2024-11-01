package board_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import dao.boardRepository;
import dao.memberRepository;
import dto.Board;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/readone")
public class board_readone extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	//목적 : 클릭한 글의 번호를 가지고와서 해당하는 내용 긁어오기
		System.out.println("board_readone get");
		//전처리
		String num = req.getParameter("num");
		System.out.println("책번호 : "+num);
		//모델이동 : 책 한권의 내용만 가지고오기 : 파라미터 줘야함
		boardRepository br = boardRepository.getInstance();
		Board bd = br.getOneBoard(num);
		req.setAttribute("board", bd);
		
		RequestDispatcher ds = req.getRequestDispatcher("view.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("board_readone post");
		
		//전처리
		
		//모델이동
		
		
		//뷰이동
		resp.sendRedirect("/BoardListAction?pageNum=1");
	}

}
