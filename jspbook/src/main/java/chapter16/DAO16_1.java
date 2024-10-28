package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DAO16_1 
{
	private DAO16_1() {};	//객체 생성 private
	private static DAO16_1 repo = new DAO16_1();
	
	public static DAO16_1 getInstance()
	{
		return repo;
	}
	
	//create
	public void member_create(DTO16_1 dto)
	{
		System.out.println("멤버생성 함수 진입");
		//db와 연결해야 함
		
		try 
		{	System.out.println("트라이");
			// 1. 일단 jdbc 드라이버 연결하기
			Class.forName("com.mysql.jdbc.Driver");
			//라이브러리 폴더 확인하기

			// 2. 커넥션 객체 생성
			Connection conn = null;
			//커넥션 객체에게 넘겨줘야 하는 것 : 데이터베이스저장경로, id, pw
			String db = "jdbc:mysql://localhost:3306/jspbook";
			String id = "root";
			String pw = "1234";
			System.out.println(db +", "+id+", "+pw);
			conn = DriverManager.getConnection(db,id,pw);
			System.out.println("데이터베이스 연결 성공");
			//이까지 하고 연결 확인
			
			//쿼리 삽입하기
			//일단 커넥션 객체한테 연결해달라고 해야 함
			Statement stmt = conn.createStatement();
			String userid = dto.getId();
			String userpw = dto.getPw();
			String username = dto.getName();
			
			String sql = "insert into member values('"+userid+"', '"+userpw+"', '"+username+"');";
			System.out.println(sql);
			//이 상태로 sql 잘 작성됐는지 확인
			//출력된거 그대로 가져가서 넣어보고 스테이트 객체 함수 이용해서 sql 삽입
			stmt.executeUpdate(sql);
			System.out.println("두 번째 sql 삽입");
			String sql2 = "insert into member values('ccc', '2344', '가자미');";
			stmt.executeUpdate(sql2);
			
			//다 썼으면 닫기
			if(stmt != null)
			{
				System.out.println("stmt close");
				stmt.close();
			}
			if(conn != null)
			{
				System.out.println("conn close");
				conn.close();
			}
		} 
		catch (Exception e) 
		{
			System.out.println("데이터베이스 연결 성공");
		}
	}
	
}
