package chapter12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.*;
import java.util.Calendar;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class logFileFilter implements Filter	//당연히 필터 클래스를 상속받아야 함
{
	PrintWriter writer;	//PrintWriter 클래스 : 로그 파일에 기록을 남겨주는 역할	 //전역변수로 선언
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		System.out.println("init....");
		String filename = filterConfig.getInitParameter("filename");	//web.xml 파일에서 param으로 넘겨주는 값 받아오는 것
		if(filename==null)
		{
			throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		}
		try
		{
			writer = new PrintWriter( new FileWriter(filename, true), true );	//전역변수 초기화
			//try 구문에서 초기화를 하는 이유 : 파일을 열거나 쓰는 과정에서 여러 가지 예외가 발생할 수 있음 : 예외처리와 코드의 안정성을 고려한 것
		}
		catch(Exception e)
		{
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException 
	{
		System.out.println("do filter....");	//여기까지 왔는지 확인
		writer.printf("현재 일시 : %s %n", getCurrentTime());
		System.out.println("현재 일시 : "+ getCurrentTime());
		String clientAddr = req.getRemoteAddr();
		writer.printf("클라이언트 주소 : %s %n", clientAddr);
		System.out.println("클라이언트 주소 : "+ clientAddr);
		
		chain.doFilter(req, resp);
		
		String contentType = resp.getContentType();
		writer.printf("문서 콘텐츠 유형 : %s %n", contentType);
		writer.println("---------------------------------------");
		System.out.println("doFilter 탈출예정");
	}
	@Override
	public void destroy() 
	{
		System.out.println("destroy....");
		writer.close();
	}
	
	private String getCurrentTime()
	{
		System.out.println("getCurrentTime 호출");
		DateFormat formatt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(formatt);
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatt.format(calendar.getTime());
	}
}
