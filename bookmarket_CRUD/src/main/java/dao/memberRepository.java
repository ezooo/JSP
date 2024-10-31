package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;

import dto.Member;

public class memberRepository 
{
	private memberRepository() {}
	private static memberRepository mr = new memberRepository();
	public static memberRepository getMr() 
	{
		return mr;
	}
	
	//데이터베이스 연결 함수
	public Connection dbconn()	//커넥션 객체 리턴할 것
	{
		System.out.println("데이터베이스 연결함수 진입");
		//일단 드라이버 연결
		Connection conn =null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			//커넥션객체 : 데이터베이스와 연결
			String url = "jdbc:mysql://localhost:3306/bookmarketDB";
			String user = "root";
			String password = "1234";
			
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 완료");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return conn;
	}
	
	//create
	public void create(Member mb)
	{
		System.out.println("member create in");
		Connection conn = null;
		PreparedStatement pstmt = null;
		//db connect
		try 
		{
			System.out.println("mem create try in");
			conn = dbconn();
			//sql 전송
			String sql = "insert into member values(?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getId());
			pstmt.setString(2, mb.getPassword());
			pstmt.setString(3, mb.getName());
			pstmt.setString(4, mb.getGender());
			pstmt.setString(5, mb.getBirth());
			pstmt.setString(6, mb.getMail());
			pstmt.setString(7, mb.getPhone());
			pstmt.setString(8, mb.getAddress());
			pstmt.setTimestamp(9, mb.getRegist_day());
			pstmt.executeUpdate();
			System.out.println("회원가입완료");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("mem create error");
		}
		finally
		{
			try 
			{
				if(pstmt != null) {pstmt.close();} 
				if(conn != null) {conn.close();}
				System.out.println("mem create finally close end");
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
				System.out.println("mem create finally error");
			}
		}
		
		//
	}
	//read
	public Member getUser(String id, String pw)
	{
		//Member data = new Member();
		Member data = null;
		//db connect
		Connection conn = dbconn();
		
		//sql
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=? and password=?";
		try 
		{
			System.out.println("login try");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			//resultset 변환 --> dto
			if(rs.next())
			{
				System.out.println("login rs setting");
				data = new Member();
				data.setId(rs.getString("id"));
				data.setPassword(rs.getString("password"));
				data.setName(rs.getString("name"));
				data.setGender(rs.getString("gender"));
				data.setBirth(rs.getString("birth"));
				data.setMail(rs.getString("mail"));
				data.setPhone(rs.getString("phone"));
				data.setAddress(rs.getString("address"));
				data.setRegist_day(rs.getTimestamp("regist_day"));
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("login fail");
		}
		return data;
	}
	//update
	
	//delete
}
