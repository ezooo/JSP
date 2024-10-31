package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.Board;

public class boardRepository 
{
	private boardRepository() {}
	private static boardRepository br = new boardRepository();
	public static boardRepository getInstance() 
	{
		return br;
	}
	
	//전역변수로 선언해버리기
	Connection conn =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//데이터베이스 연결 함수
	public Connection dbconn()	//커넥션 객체 리턴할 것
	{			
		System.out.println("데이터베이스 연결함수 진입");
		try 
		{
			//일단 드라이버 연결
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
	
	//행의 갯수 리턴
	public int getTotalCount()
	{
		System.out.println("getTotalCount in");
		int count = 0;
		//db conn
		Connection conn = dbconn();
		//query send
		String sql = "select count(*) from board";
		
		try 
		{
			System.out.println("getTotalCount try in");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//resultset
			if(rs.next())
			{
				count = rs.getInt(1);
				//원래 컬럼명 들어가야하는데 순서 넣어도 됨 첫번째 컬럼....
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(pstmt != null) {pstmt.close();} 
				if(conn != null) {conn.close();}
				System.out.println("getTotalCount finally");
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
				System.out.println("getTotalCount finally error");
			}
		}
		return count;
	}
	
	//c
	public void create(Board bd)
	{
		
	}
	//r all
	public ArrayList<Board> getAllBoard()
	{
		System.out.println("get all board in");
		//ArrayList<Board> arr = null;
		ArrayList<Board> arr = new ArrayList<Board>();
		
		Connection conn = dbconn();
		String sql = "select * from board";
		try 
		{
			System.out.println("get all board try");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Board bd = new Board();
				bd.setNum(rs.getInt("num"));
				bd.setId(rs.getString("id"));
				bd.setName(rs.getString("name"));
				bd.setSubject(rs.getString("subject"));
				bd.setContent(rs.getString("content"));
				bd.setRegist_day(rs.getTimestamp("regist_day"));
				bd.setHit(rs.getInt("hit"));
				bd.setIp(rs.getString("ip"));
				
				arr.add(bd);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			System.out.println("get all board error");
		}
		finally
		{
			try 
			{
				if(pstmt != null) {pstmt.close();} 
				if(conn != null) {conn.close();}
				System.out.println("get all board finally");
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
				System.out.println("");
			}
		}
		return arr;
	}
	

	//r one
	public Board getOneBoard()
	{
		Board bd = null;
		return bd;
	}
	//u
	//d
}
