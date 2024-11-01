package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
	ArrayList<Board> arrb = null;
	
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
		System.out.println("board create() in");
		conn = dbconn();
		//보드 내용 꺼내기
		String name = bd.getName();
		String subject = bd.getSubject();
		String content = bd.getContent();
		String id = bd.getId();
		java.sql.Timestamp timestamp = bd.getRegist_day();
		int hit = 0;	//아직 조회안됨
		String ip = bd.getIp();

		String sql = "insert into board(id, name, subject, content, regist_day, hit, ip) values(?,?,?,?,?,?,?)";
		try 
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, subject);
			pstmt.setString(4, content);
			pstmt.setTimestamp(5, timestamp);
			pstmt.setInt(6, hit);
			pstmt.setString(7, ip);
			
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			System.out.println("board create() error");
		}
		System.out.println("board create() 완료");
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
	public Board getOneBoard(String num)
	{
		System.out.println("getOneBoard in");
		Board bd = null;
		//db연결
		conn = dbconn();
		//쿼리작성
		String sql = "select * from board where num=?";
		try 
		{
			System.out.println("getOneBoard try in");
			pstmt = conn.prepareStatement(sql);
			//받아올 dto가 있다 : resultset
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			//rs 내용꺼내서 dto담기
			if(rs.next())
			{
				System.out.println("getOneBoard rs 내용꺼내기");
				bd = new Board();
				bd.setName(rs.getString("name"));
				bd.setSubject(rs.getString("subject"));
				bd.setContent(rs.getString("content"));
				System.out.println("getOneBoard rs 내용 삽입완료");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			System.out.println("getOneBoard try error");
		}		
		return bd;
	}
	//u
	//d
}
