package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.bookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addCart")
public class addCart extends HttpServlet	//역할? 폼 제출 시 장바구니에 추가
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("addCart.java 진입");
		//전처리
		String id = req.getParameter("id");
		System.out.println("아이디는"+id);
		if(id==null || id.trim().equals(""))
		{
			System.out.println("addcart if진입");
			resp.sendRedirect("books.jsp"); //books.jsp
			return;
		}
		//모델
		bookRepository dao = bookRepository.getRepository();
		Book book = dao.getBookById(id);
		System.out.println("book : "+book);
		if(book==null)
		{
			System.out.println("북없음");
			resp.sendRedirect("exceptionNoBookId.jsp");	//수정가능한지 확인하기
		}
		
		ArrayList<Book> goodsList = dao.getAllBooks();
		Book goods = new Book();
		System.out.println("굿즈 : "+goods);
		for(int i=0; i<goodsList.size(); i++)
		{
			goods=goodsList.get(i);	//리스트에  담긴거 하나씩 꺼내서 유효성검사
			if(goods.getBookId().equals(id))
			{
				System.out.println("굿즈탈출");
				break;
			}
		}
		HttpSession session = req.getSession(false);
		ArrayList<Book> list = (ArrayList<Book>)session.getAttribute("cartlist");	//세션에서 목록꺼내기
		if(list==null)
		{
			list=new ArrayList<Book>();	//없으면 카트 아직 안 만든거니까 새로 만들기
			session.setAttribute("cartlist", list);
		}
		
		int cnt=0;
		Book goodsQnt = new Book();	//북객체 또 만듦
		for(int i=0; i<list.size(); i++)
		{
			goodsQnt=list.get(i);
			if(goodsQnt.getBookId().equals(id))
			{
				cnt++;
				int orderQnt = goodsQnt.getQuantity()+1;	//장바구니에 이미 동일상품이 있으면 갯수만 증가
				goodsQnt.setQuantity(orderQnt);
			}
		}
		if(cnt==0)
		{
			goods.setQuantity(1);
			list.add(goods);
		}
		
		resp.sendRedirect("book?id="+id);	//이거 나중에 수정해야 할 듯
	}

}
