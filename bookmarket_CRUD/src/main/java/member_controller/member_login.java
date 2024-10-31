package member_controller;

import java.io.IOException;

import dao.memberRepository;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/member_login")
public class member_login extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("member_login get");
		//전처리
		//모델이동
		//뷰이동
		RequestDispatcher ds = req.getRequestDispatcher("loginMember.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("member_login post");
		//전처리
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		//모델이동
		memberRepository mr = memberRepository.getMr();
		Member mb =	mr.getUser(id,pw);
			//mb 유효성검사
		if(mb != null)	//dto가 존재하므로 회원이 맞음 (등록된 회원이 있다)
		{
			//세션 생성
			HttpSession ssn = req.getSession(true);
			ssn.setAttribute("member", mb);	//이러면 repository 갈 필요 없ㄷ
			//뷰이동
			RequestDispatcher ds = req.getRequestDispatcher("resultMember.jsp?msg=2");
			ds.forward(req, resp);
		}
		else
		{
			resp.sendRedirect("member_login?error=1"); 	//다시 로그인창으로 보냄
		}
	}
}
