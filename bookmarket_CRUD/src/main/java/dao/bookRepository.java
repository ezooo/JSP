package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dto.Book;

public class bookRepository 
{
	public bookRepository(){}	//생성자
	
	//저장소 변수 : 하나만 있어야 함 : 그래야 한 곳에 쌓음
	private static ArrayList<Book> listOfBooks = new ArrayList<Book>();	//book 객체묶음

	private static bookRepository repository = new bookRepository();
	
	public static bookRepository getRepository()
	{
		return repository;
	}
	
//데이터베이스 연결 함수
	public Connection dbconn() throws Exception	//커넥션 객체 리턴할 것
	{
		System.out.println("데이터베이스 연결함수 진입");
		//일단 드라이버 연결
		Class.forName("com.mysql.jdbc.Driver");
		
		//커넥션객체 : 데이터베이스와 연결
		Connection conn =null;
		String url = "jdbc:mysql://localhost:3306/bookmarketDB";
		String user = "root";
		String password = "1234";
		
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("데이터베이스 연결 완료");
		
		return conn;
	}
	
	public ArrayList<Book> getAllBooks()
	{ //db 자료 가져오는 구조로 만들기
		System.out.println("get all books 진입");
		ResultSet rs = null;
		ArrayList<Book> arr = new ArrayList<Book>();
		try 
		{
			//데이터베이스 연결부터
			Connection conn = dbconn();
			System.out.println("conn : "+conn);
			//sql 작성
			String sql = "select * from book;";
			System.out.println(sql);
			//statement 객체
			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(sql);	//conn이 함수 가지고 있음
			//함수에  sql 넣었으면 execute하기
			rs = pstmt.executeQuery();
			//명령어 실행하고 나면 결과를 받아와야 함 -- resultset
			//execute결과를 rs에 담아야 함
			while(rs.next())
			{
				String b_id = rs.getString("b_id");
				String b_name = rs.getString("b_name");
				int b_unitPrice = rs.getInt("b_unitPrice");
				String b_author = rs.getString("b_author");
				String b_description = rs.getString("b_description");
				String b_publisher = rs.getString("b_publisher");
				String b_category = rs.getString("b_category");
				int b_unitsInStock = rs.getInt("b_unitsInStock");
				String b_releaseDate = rs.getString("b_releaseDate");
				String b_condition = rs.getString("b_condition");
				String b_fileName = rs.getString("b_fileName");
				
				//dto로 묶기
				Book dto = new Book();
				dto.setBookId(b_id);
				dto.setName(b_name);
				dto.setUnitPrice(b_unitPrice);
				dto.setAuthor(b_author);
				dto.setDescription(b_description);
				dto.setPublisher(b_publisher);
				dto.setCategory(b_category);
				dto.setUnitsInStock(b_unitsInStock);
				dto.setReleaseDate(b_releaseDate);
				dto.setCondition(b_condition);
				dto.setFilename(b_fileName);
				//dto를 arraylist에 담기
				arr.add(dto);
			}
			System.out.println("get all books 실행 완료");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("get all books error");
		}
		return arr;
	}
	
	
	public Book getBookById(String bookId)
	{
		System.out.println("getbook 함수진입");
		
		PreparedStatement pstmt = null;	
		//받아올거있음
		ResultSet rs = null;
		Book dto = new Book();
		try 
		{
			Connection conn = dbconn();
			System.out.println("getbook db연결완료");
			String sql = "select * from book where b_id=?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookId);
			
			rs = pstmt.executeQuery();
			//rs가 dto..하나인데 dto에 담아야 함
			if(rs.next())
			{
				String b_id = rs.getString("b_id");
				String b_name = rs.getString("b_name");
				int b_unitPrice = rs.getInt("b_unitPrice");
				String b_author = rs.getString("b_author");
				String b_description = rs.getString("b_description");
				String b_publisher = rs.getString("b_publisher");
				String b_category = rs.getString("b_category");
				int b_unitsInStock = rs.getInt("b_unitsInStock");
				String b_releaseDate = rs.getString("b_releaseDate");
				String b_condition = rs.getString("b_condition");
				String b_fileName = rs.getString("b_fileName");
				
				//dto로 묶기
				dto.setBookId(b_id);
				dto.setName(b_name);
				dto.setUnitPrice(b_unitPrice);
				dto.setAuthor(b_author);
				dto.setDescription(b_description);
				dto.setPublisher(b_publisher);
				dto.setCategory(b_category);
				dto.setUnitsInStock(b_unitsInStock);
				dto.setReleaseDate(b_releaseDate);
				dto.setCondition(b_condition);
				dto.setFilename(b_fileName);
			}
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getbook error");
		}
		return dto;
	}
	
	public void addBook(Book book)
	{	//db insert
		try 
		{
			System.out.println("addbook try");
			Connection conn = dbconn();
			
			//이건 set이라서 resultset 필요없음
			PreparedStatement pstmt = null;
			String sql = "insert into book values(?,?,?,?,?,?,?,?,?,?,?)";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, book.getBookId());
			pstmt.setString(2, book.getName());
			pstmt.setInt(3, book.getUnitPrice());
			pstmt.setString(4, book.getAuthor());
			pstmt.setString(5, book.getDescription());
			pstmt.setString(6, book.getPublisher());
			pstmt.setString(7, book.getCategory());
			pstmt.setLong(8, book.getUnitsInStock());
			pstmt.setString(9, book.getReleaseDate());
			pstmt.setString(10, book.getCondition());
			pstmt.setString(11, book.getFilename());
			
			pstmt.executeUpdate();
			
			if(pstmt != null)
			{
				pstmt.close();
			}
			if(conn != null)
			{
				conn.close();
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("addbook error");
		}
	}

	public void updateBook(Book book)
	{
		try 
		{
			System.out.println("updatebook try");
			Connection conn = dbconn();
			
			PreparedStatement pstmt = null;
			String sql = "update book set b_name=?, b_unitPrice=?, b_author=?, b_description=?, b_publisher=?, b_category=?, b_unitsInStock=?, b_releaseDate=?, b_condition=?, b_fileName=? where b_id=?";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, book.getName());
			pstmt.setInt(2, book.getUnitPrice());
			pstmt.setString(3, book.getAuthor());
			pstmt.setString(4, book.getDescription());
			pstmt.setString(5, book.getPublisher());
			pstmt.setString(6, book.getCategory());
			pstmt.setLong(7, book.getUnitsInStock());
			pstmt.setString(8, book.getReleaseDate());
			pstmt.setString(9, book.getCondition());
			pstmt.setString(10, book.getFilename());
			pstmt.setString(11, book.getBookId());
			
			pstmt.executeUpdate();
			
			if(pstmt != null)
			{
				pstmt.close();
			}
			if(conn != null)
			{
				conn.close();
			}
			System.out.println("update 완료");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("업데이트 에러");
		}
		
	}
}
