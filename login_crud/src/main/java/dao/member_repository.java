package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import dto.member_dto;

public class member_repository 
{
	//1개만 존재해야 하므로 싱글턴 패턴으로 작성
	private static member_repository mr = new member_repository();
	public static member_repository getInstance()
	{
		return mr;	//싱글턴
	}
	
	//create
	public void member_create(member_dto dto)	//생성 : 리턴없다 : 보이드
	{	//받아올 거 있어야 함 (묶음처리한 dto 받아옴)
		try 
		{
			//step1 : JDBC 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");	//특정클래스 찾아주는 역할
			
			//step2 : Connection 객체 생성
			// 확인사항 : 1.데이터베이스 생성여부 2.WEBINF/lib 폴더에 라이브러리 확인
			Connection conn = null;
			String database ="jdbc:mysql://localhost:3306/login_crud";
			String id="root";
			String pw="1234";
			conn = DriverManager.getConnection(database, id, pw);
			//PrintWriter out = new PrintWriter(null);
			//out.println("데이터베이스 연결 완료");
			System.out.println("데이터베이스 연결 완료");
			
		} 
		catch (Exception e) 
		{
			System.out.println("데이터베이스 연결 오류");
		}
		
		
		
		//step3 : SQL 전송객체 생성 및 전송
		
		//step4 : 리턴이 있다면 ResultSet 객체에 담기 -- CUD는 해당 없음
		
		
	}
	//read
	
	//update
	
	//delete
}
