package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class logFileFilter implements Filter
{
	PrintWriter writer; //로그파일에 기록을 작성하는 역할
	@Override
	public void init(FilterConfig config) throws ServletException 
	{
		System.out.println("init...."); //필터 초기화 확인
		String filename = config.getInitParameter("filename"); //web.xml에 작성한 내용 받아오는 것
		
		if(filename==null)
		{
			System.out.println("if 동작");
			throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		}
		try
		{
			writer = new PrintWriter( new FileWriter(filename, true), true );
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
		System.out.println("do filter....");
		writer.println("접속한 클라이언트 IP : "+ req.getRemoteAddr());
		long start = System.currentTimeMillis();
		writer.println(" 접근한 URL 경로 : "+ getURLPath(req));
		writer.println(" 요청 처리 시작 시각 : "+ getCurrentTime());
		
		chain.doFilter(req, resp);
		
		long end = System.currentTimeMillis();
		writer.println(" 요청 처리 종료 시각 : "+ getCurrentTime());
		writer.println(" 요청 처리 소요 시각 : "+ (end-start)+"ms ");
		writer.println("==========================================");
		System.out.println("doFilter 탈출예정");
	}
	@Override
	public void destroy() {
		writer.close();
	}

	private String getURLPath(ServletRequest request)
	{
		HttpServletRequest req;
		String currentPath="";
		String queryString="";
		
		if(request instanceof HttpServletRequest)
		{
			req=(HttpServletRequest)request;
			currentPath=req.getRequestURI();
			queryString=req.getQueryString();
			queryString= (queryString==null ? "": "?") + queryString;
		}
		return currentPath+queryString;
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
