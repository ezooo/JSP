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
import jakarta.servlet.http.HttpSession;

@WebServlet("/BoardWriteForm")
public class board_write extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("board_write get");
		
		HttpSession session = req.getSession(false);
		
		if(session == null)
		{
			System.out.println("BoardWriteForm 세션이 없습니다.");
			resp.sendRedirect("member_login");
		}
		else
		{
			RequestDispatcher ds = req.getRequestDispatcher("writeForm.jsp");
			ds.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("board_write post");
		
		//전처리
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String year = request.getParameter("birthyy");
		String month = request.getParameterValues("birthmm")[0];
		String day = request.getParameter("birthdd");
		String birth = year + "/" + month + "/" + day;
		String mail1 = request.getParameter("mail1");
		String mail2 = request.getParameterValues("mail2")[0];
		String mail = mail1 + "@" + mail2;
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		Date currentDatetime = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
		java.sql.Timestamp timestamp = new java.sql.Timestamp(currentDatetime.getTime());
		//셋 다 현재 시간
		Member mb = new Member();
		mb.setId(id);
		mb.setPassword(password);
		mb.setName(name);
		mb.setGender(gender);
		mb.setBirth(birth);
		mb.setMail(mail);
		mb.setPhone(phone);
		mb.setAddress(address);
		mb.setRegist_day(timestamp);
		//시간은 타임스탬프쓰기 -- db에 varchar 돼있어도 알아서 형식잡아서 넣어준다고 함
		//모델이동
		memberRepository mr = memberRepository.getMr();
		mr.create(mb);
		
		//뷰이동
		resp.sendRedirect("/bookmarket_CRUD");
	}
}
