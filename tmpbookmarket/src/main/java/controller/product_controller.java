package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.bookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class product_controller extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//verify step 1 : 콘솔을 찍어서 매핑 잘되는지 확인
		System.out.println("/products 매핑됨");
		//전처리
			//뭔가 만들어서 전달하기 위해 전처리 하는건데 지금은 get으로 받는 것만 있으니까 전처리 안함
		//모델 
		ArrayList<Book> arr =bookRepository.getAllBooks(); //저장소 무조건 연결해줘야함 컨트롤러에서 이 줄은 무조건 있어야 한다.
			//get은 반드시 리턴이 있다 (뭘 돌려준다) : 받아야 함 : 변수에 담기
		//이동
			//데이터 실어보낼 때 키,값 이렇게 보내야 함
		req.setAttribute("array", arr); //set이다 : void : 받을게 없다 : 그래서 앞에 코드가 필요없음
		//이동할때 데이터 가져가는 방법 : set
		RequestDispatcher ds = req.getRequestDispatcher("books.jsp");
		ds.forward(req, resp);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
	}
}
