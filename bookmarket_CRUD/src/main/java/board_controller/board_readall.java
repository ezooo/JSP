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

@WebServlet("/BoardListAction")
public class board_readall extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("board_readall get");
		
		int limit = 5;	//한 페이지에 출력할 글의 갯수를 제한
		//전처리
		int pagenum = Integer.parseInt(req.getParameter("pageNum"));
		//모델이동
		boardRepository br = boardRepository.getInstance();
		ArrayList<Board> arr = br.getAllBoard();
		
		//모델 한번 더 가야함 !!!
		int total_record = br.getTotalCount();
		int total_page = 0;
		if(total_record % limit ==0)
		{
			total_page = total_record/limit;
		}
		else
		{
			total_page = (total_record/limit) +1;
		}
		//뷰이동
		req.setAttribute("list", arr);	//전체 글을 담은 객체
		req.setAttribute("pageNum", pagenum);	//현재 페이지 번호
		req.setAttribute("total_record", total_record);	//전체 글의 갯수
		req.setAttribute("total_page", total_page);	//출력할 페이지의 갯수
		
		RequestDispatcher ds = req.getRequestDispatcher("list.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("board_readall post");
		
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
