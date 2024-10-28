package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.DTO3;

public class DAO3 
{
	private DAO3() {};
	private static DAO3 dao = new DAO3();
	public static DAO3 getInstance()	//static 안하면 컨트롤 에러남
	{
		return dao;
	}
	
	
	public Connection dbconn()
	{	//db와 연결하기
		//드라이버연결
		//connect
		Connection conn = null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
					
			//커넥션에 넘겨줄거
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspbook", "root", "1234");
			System.out.println("db connect");
		} 
		catch (Exception e) 
		{
			System.out.println("connect fail");
		}
		finally
		{
			return conn;
		}
	}
	
	public void member_create(DTO3 dto)
	{
		System.out.println("dao3 create");
		//드라이버연결
		try 
		{
			Connection conn = dbconn();
			
			//연결됐으면 쿼ㅣ리 넘겨줘야함
			PreparedStatement pstmt = null;
				//sql 넣어주기
			String sql = "insert into member values(?,?,?)";
			pstmt = conn.prepareStatement(sql);	//이 부분이 생각잘안남
			//sql 넣었으면 변수처리하기
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			
			System.out.println("들어갔나 확인하기");
			pstmt.executeUpdate();
		} 
		catch (Exception e) 
		{
			System.out.println("create error");
		}
	}
	
	public ArrayList<DTO3> member_readall()
	{		//이거는 모든 dto를 넘겨줘야 함 : 근데 리턴은 하나 : ArrayList로 넘겨야 함
		//일단 어레이리스트 먼저 만들기
		ArrayList<DTO3> arr = new ArrayList<DTO3>();
		//그리고 dto를 데이터베이스에서 받아와야 함
		//연결 : create와 겹침 : 함수로 만들어서 빼주자
		Connection conn = dbconn();
		PreparedStatement pstmt = null;
		String sql = "select * from member;";
		System.out.println(sql);
		
		//데이터베이스에서 테이블 받아오려면 resultset 써야 함
		ResultSet rs = null;
		try 
		{
			System.out.println("readall try");
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				
				//받아와서 또 dto에 담음
				DTO3 dto = new DTO3();
				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				//이걸 어레이리스트에 담기
				arr.add(dto);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("readall error");
		}
		return arr;
	}
}
