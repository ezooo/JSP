package chapter07;

import java.io.*;
import java.util.*;

import org.apache.commons.fileupload.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/7_3")
public class exam07_3 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("doget");
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/file03.jsp");
		ds.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("dopost");
		
		String filePath = req.getServletContext().getRealPath("img"); //파일저장경로
		System.out.println(filePath);
		
		DiskFileUpload upload = new DiskFileUpload(); //메서드 쓰기위해 객체생성
		try 
		{
			System.out.println("try");
			List items = upload.parseRequest(req);
			Iterator params = items.iterator();
			
			while(params.hasNext())
			{
				FileItem fileItem = (FileItem)params.next();
				if(!fileItem.isFormField()) //폼필드인가 : 텍스트인지 아닌지 묻는거
				{
					String fileName = fileItem.getName(); //파일이면 이름을 알아야 함
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
					File file = new File(filePath + "/" +fileName); //새파일만들기(빈거)
					fileItem.write(file); //내용 채우기
					System.out.println("파일생성");
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println("catch");
		}	
	}
}
