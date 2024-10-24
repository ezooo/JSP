package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import dao.bookRepository;
import dto.Book;

@WebServlet("/addBook")
public class addBook extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("addBook.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("addbook_doPost");
		req.setCharacterEncoding("utf-8"); //나중에 파라미터에 실어보낼 때 텍스트 안 깨지도록 감싸는 것
		
		//String filename = ""; //파일네임 변수 생성
		String realFolder = req.getServletContext().getRealPath("/resource/images");
		System.out.println("폴더명 : "+realFolder); //프로젝트폴더까지 반환해주는 것 확인
		
		//String realFolder = path+"/resource/images";
		//System.out.println(realFolder);
		int maxSize = 5*1024*1024;  //최대 업로드 될 파일의 크기
		String encType = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		String bookId = multi.getParameter("bookId");  //객체 전부 multi로 변경	//다 전처리 작업
		System.out.println(bookId);
		String name = multi.getParameter("name");
		String unitPrice = multi.getParameter("unitPrice");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher");
		String releaseDate = multi.getParameter("releaseDate");
		String description = multi.getParameter("description");
		String category = multi.getParameter("category");
		String unitsInStock = multi.getParameter("unitsInStock");
		String condition = multi.getParameter("condition");
		
		String fileName = multi.getFilesystemName("bookImage"); //addBook에서 넘겨준 변수명(name)
		System.out.println("파일명 : "+fileName);
		
		Integer price;	//숫자여야 하는거 숫자로 바꿔주는것 
		if(unitPrice.isEmpty())
		{
			price=0;
		}
		else
		{
			price=Integer.valueOf(unitPrice);
		}
		
		long stock;
		if(unitsInStock.isEmpty())
		{
			stock=0;
		}
		else
		{
			stock=Long.valueOf(unitsInStock);
		}
		
		
		//묶음처리
		Book newBook = new Book();
		newBook.setBookId(bookId);
		newBook.setName(name);
		newBook.setUnitPrice(price);
		newBook.setAuthor(author);
		newBook.setPublisher(publisher);
		newBook.setReleaseDate(releaseDate);
		newBook.setDescription(description);
		newBook.setCategory(category);
		newBook.setUnitsInStock(stock);
		newBook.setCondition(condition);
		newBook.setFilename(fileName);

		//이건 전처리.. 는 아니고 모델 이동
		bookRepository dao = bookRepository.getRepository();
		dao.addBook(newBook);
		
		response.sendRedirect("products");	//처음 컨트롤러로 연결
		//sendRedirect 는 컨트롤러에서 나갔다가 다시 컨트롤러로 돌아옴
	}
}
