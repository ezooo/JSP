<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.oreilly.servlet.*" %>
<%@ page import = "com.oreilly.servlet.multipart.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MultipartRequest multi = new MultipartRequest(request,
			"C:\\upload", 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());

	Enumeration params = multi.getParameterNames();
	
	while(params.hasMoreElements())
	{
		String name = (String)params.nextElement();
		String value = multi.getParameter(name);
		out.print(name + " = " + value +"<br>");
	}
	out.print("---------------------------------<br>");
	
	Enumeration files = multi.getFileNames();
	//String file = multi.getFilesystemName(name);
	
	while(files.hasMoreElements())
	{
		String name = (String)files.nextElement();
		String filename = multi.getFilesystemName(name);
		String original = multi.getOriginalFileName(name);
		String type = multi.getContentType(name);
		File file = multi.getFile(name);
		out.print("요청 파라미터 이름 : "+name + "<br>");
		out.print("실제 파일 이름 : "+original + "<br>");
		out.print("저장 파일 이름 : "+filename + "<br>");
		out.print("파일 콘텐츠 유형 : "+type + "<br>");
		
		if(file != null)
		{
			out.print("파일 크기 : "+file.length());
			out.print("<br>");
		}
	}
%>

</body>
</html>