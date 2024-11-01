package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import dto.Book;

public class bookRepository_copy 
{
	//저장소 변수 : 하나만 있어야 함 : 그래야 한 곳에 쌓음
	private static ArrayList<Book> listOfBooks = new ArrayList<Book>();
	
//	public static bookRepository getInstance()
//	{
//		return instance; //이거 밑에 있어서 싱글톤이 아니게 됨 하나만 만들 것
//	}

	private static bookRepository_copy repository = new bookRepository_copy();
	
	public bookRepository_copy() //저장소생성자 : 
	{
		Book book1 = new Book("ISBN1234", "C# 프로그래밍", 27000);
		book1.setAuthor("우재남");
		book1.setDescription("C#을 처음 접하는 독자를 대상으로 일대일 수업처럼 자세히 설명한 책이다. 우어어어ㅓ거거ㅓ우멷ㅎㅎㅇ.ㅁ뎧");
		book1.setPublisher("한빛아카데미");
		book1.setCategory("IT모바일");
		book1.setUnitsInStock(1000);
		book1.setReleaseDate("2022/10/06");
		book1.setFilename("ISBN1234.jpg");
		
		Book book2 = new Book("ISBN1235", "자바마스터", 30000);
		book2.setAuthor("송미영");
		book2.setDescription("자바를 처음 배우는 학생을 위해 자바의 기본 개념과 실습 예제를 그림을 이용하여 쉽게 설명합니다. ㄷ두ㅜ두ㅜㅇ가ㅕㄱ웜도ㅕㅓㅗㅊ");
		book2.setPublisher("한빛아카데미");
		book2.setCategory("IT모바일");
		book2.setUnitsInStock(1000);
		book2.setReleaseDate("2023/01/02");
		book2.setFilename("ISBN1235.jpg"); //객체 생성시 도서 이미지 설정 같이 하기
		
		Book book3 = new Book("ISBN1236", "파이썬 프로그래밍", 30000);
		book3.setAuthor("최성철");
		book3.setDescription("파이썬으로 프로그래밍을 시작하는 입문자가 쉽게 이해할 수 있도록 기본 개념을 상세하게 설명하며, 다양한 예제를 제시합니다. 가가가ㅏ여ㅕㅕㄱ너커커ㅕㅕ거ㅣㅁㄷ");
		book3.setPublisher("한빛아카데미");
		book3.setCategory("IT모바일");
		book3.setUnitsInStock(1000);
		book3.setReleaseDate("2023/01/01");
		book3.setFilename("ISBN1236.jpg");
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}
	
	public static ArrayList<Book> getAllBooks()
	{ //얘는 원래 스태틱 안해도 되지만 위에 것들이 외부에서 접근이 안됨 : 그래서 얘도 스태틱 해줘야 함
		return listOfBooks;
	}
	
	public static bookRepository_copy getRepository()
	{
		return repository;
	}
	
	public Book getBookById(String bookId)
	{
		Book bookById = null;
		
		for(int i=0; i<listOfBooks.size(); i++)
		{
			Book book = listOfBooks.get(i);
			if(book != null && book.getBookId()!=null && book.getBookId().equals(bookId))  //arrayList는 객체를 담음 그러니까 book. 해서 함수쓰는거
			{
				bookById = book;
				break;
			}
		}
		return bookById;
	}
	
	public void addBook(Book book)
	{
		listOfBooks.add(book);
	}

//데이터베이스 연결 함수
	public Connection dbconn() throws Exception	//커넥션 객체 리턴할 것
	{
		//일단 드라이버 연결
		Class.forName("com.mysql.jdbc.Driver");
		//커넥션객체 : 데이터베이스와 연결
		Connection conn =null;
		
		String url = "jdbc:mysql://localhost:3306/bookmarketdb";
		String user = "root";
		String password = "1234";
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("데이터베이스 연결 완료");
		
		return conn;
	}
	
	

}
