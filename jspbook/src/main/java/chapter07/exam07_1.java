package chapter07;

import java.io.*;
import java.util.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_1")
public class exam07_1 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/file01.jsp");
		ds.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException 
	{
		//전처리 (jsp에 있던 내용 컨트롤러에서 처리.. jsp는 뷰니까)
		//근데 C드라이브에는 접근 안하는게 좋다. 왠만하면 webapp 안에서 작업할 것
		//저장할 경로를 메타데이터안에.. run 했을 때 실제로 객체생성하고 하는 폴더로 만들기
		//경로 찾아와야 함
		String save = request.getServletContext().getRealPath("img");
		//내가 만든 이미지 폴더의 실제 경로를 찾아오라고 한 것
		MultipartRequest multi = new MultipartRequest(request,
				save, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		//뷰에서는 바로 출력할 수 있지만 컨트롤러에서는 바로 출력할 수 없으니까 반복문으로 변수에 뭔가 넣는 것 보다는 직접 하나씩 해야함
		
		
		
		RequestDispatcher ds = request.getRequestDispatcher("chapter07/file01_process.jsp");
		ds.forward(request, resp);
	}
}
