package board_controller;

import java.io.IOException;
import java.sql.Timestamp;
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
import jakarta.servlet.http.HttpSession;

@WebServlet("/BoardWriteForm")
public class board_write extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("board_write get");
		
		HttpSession session = req.getSession(false);
		RequestDispatcher rs=null;
		System.out.println(session);
		if(session == null) 
		{
			rs = req.getRequestDispatcher("member_login");
		}
		else if(session != null)
		{
			Member mb = (Member)session.getAttribute("member");
			if(session.getAttribute("member") == null) 
			{
				System.out.println("세션존재 멤버 없음 이동한다");
				rs = req.getRequestDispatcher("member_login");
			}
			else 
			{
				rs = req.getRequestDispatcher("writeForm.jsp");            
			}
		}
			      
		rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("board_write post");
		
		//전처리
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		//전달받은 정보는 3개
		//채워줘야 하는건??
		//아이디, 등록시간, 조회수, 아이피주소 : 아이디-세션에서 가져온다
		HttpSession ssn = req.getSession(false);
		Member mb = (Member)ssn.getAttribute("member");
		String id = mb.getId();
			//시간구하는게 좀 귀찮은...형태
		Date currentDatetime = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
		java.sql.Timestamp timestamp = new java.sql.Timestamp(currentDatetime.getTime());
		
		int hit = 0;	//아직 조회안됨
		String ip = req.getRemoteAddr();
		
		Board bd = new Board();
		bd.setName(name);
		bd.setSubject(subject);
		bd.setContent(content);
		bd.setId(id);
		bd.setRegist_day(timestamp);
		bd.setHit(hit);
		bd.setIp(ip);
		
		//모델이동
		boardRepository br = boardRepository.getInstance();
		br.create(bd);
		
		//뷰이동
		resp.sendRedirect("BoardListAction");
	}
}
