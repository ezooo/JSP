package chapter13;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/13_3")
public class exam13_3 extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("13_3 get");
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_3.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("13_3 post");
		//전처리
//		String name;
//		String value;
//		
//		
//		Enumeration en = session.getAttributeNames();	//가져올 속성 값이 여러 개 일때 혹은 이름을 모를 때
//		int i=0;
//		
//		while(en.hasMoreElements())
//		{
//			i++;
//			name = en.nextElement().toString();
//			value = session.getAttribute(name).toString();	//이게 원래 하려던 것
//			System.out.println("설정된 세션의 속성 이름 ["+i+"] : "+name);
//			System.out.println("설정된 세션의 속성 값 ["+i+"] : "+value);
//		}

	}

}
