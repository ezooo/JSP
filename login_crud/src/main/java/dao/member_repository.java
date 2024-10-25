package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.member_dto;

public class member_repository 
{
	//1개만 존재해야 하므로 싱글턴 패턴으로 작성
	private static member_repository mr = new member_repository();
	public static member_repository getInstance()
	{
		return mr;	//싱글턴
	}
	
	//데이터베이스 연결 메서드
	//얘는 연결정보를 객체로 제공해야 함 : 리턴 있다
	private Connection DBconn() throws Exception
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
		
		return conn;	//커넥션을 넘겨줘야 함
	}
	
	//create
	public void member_create(member_dto dto)	//생성 : 리턴없다 : 보이드
	{	//받아올 거 있어야 함 (묶음처리한 dto 받아옴)
		System.out.println("생성 함수 진입");
		try 
		{
			Connection conn = DBconn(); 	//그냥 함수호출 하나로 끝내기
					
			//step3 : SQL 전송객체 생성 및 전송
			//SQL 쿼리를 전송해야 함 : 데이터베이스에 데이터를 삽입하는 절차
			Statement stmt = conn.createStatement();
			String userid = dto.getId();
			String userpw = dto.getPw();
			int age = dto.getAge();
			
			String sql = "insert into member values('"+userid+"','"+userpw+"',"+age+")";	//문자열로 적음
			//"insert into member values('admin','1234',7)"; : 워크벤치에 복붙해서 테스트 실행
			//고정된 문자열이 아니라 변수 같이 보내려면
			//"insert into member values('userid','userpw',age)"; 이거 전체가 문자열이어야 한다는건 변하지 않음!!!
			//그래서 이렇게 틀 먼저 잡아놓고 변수 있는 부분 쪼개기
			//"insert into member values('"+userid
			//userid+"','"+userpw
			//userpw+"',"+age
			//age+")"	//이렇게 다 쪼개봐야 쉽게 적을 수 있음
			//"insert into member values('"+userid+"','"+userpw+"',"+age+")";
			stmt.executeUpdate(sql);	//이게 보내는 거 (알아서 db에 집어넣음)
			
		} 
		catch (Exception e) 
		{
			System.out.println("데이터베이스 연결 오류");
		}
		

		//step4 : 리턴이 있다면 ResultSet 객체에 담기 -- CUD는 해당 없음	
	}

	//read
	public ArrayList<member_dto> getAllmember() 
	{
		System.out.println("select all 함수 진입");
		ResultSet rs = null;
		ArrayList<member_dto> arr = new ArrayList<member_dto>();
		try
		{
			Connection conn = DBconn();	//커넥션받기 (리턴받은 거 담아야 쓸 수 있다)
			Statement stmt = conn.createStatement();
			String sql = "select * from member";	//전체 다 읽어올거
			
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				String id = rs.getString("id");	//컬럼명 넣음
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				//이까지 하면 한 '행'을 가져오는 것
				
				member_dto dto = new member_dto();	//새로 만듦
				dto.setId(id);
				dto.setPw(pw);
				dto.setAge(age);
				
	//			member_dto dto = new member_dto();	//위에 두 과정 한번에 하는 거
	//			dto.setId(rs.getString("id"));
	//			dto.setPw(rs.getString("pw"));
	//			dto.setAge(rs.getInt("age"));
				
				arr.add(dto);
			}
		}
		catch(Exception e){ }
		
		return arr;
	}

	//update
	public member_dto getOnemember(String userid)
	{
		System.out.println("업데이트-수정페이지 함수 진입");
		member_dto dto = new member_dto();	//새로 만듦
		try 
		{
			ResultSet rs = null;
			//step1 db connect
			Connection conn = DBconn();
			//step2 Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql = "select * from member where id='"+userid+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				String id = rs.getString("id");	//컬럼명 넣음
				String pw = rs.getString("pw");
				int age = rs.getInt("age");
				
				dto.setId(id);
				dto.setPw(pw);
				dto.setAge(age);
			}
		} 
		catch(Exception e){ }
		return dto;
	}
	
	public void update_member(member_dto dto)
	{
		System.out.println("업데이트-수정완료 함수 진입");
		try 
		{
			//step1 db connect
			Connection conn = DBconn();
			//step2 Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql = "update member set pw='"+dto.getPw()+"', age="+dto.getAge()+" where id='"+dto.getId()+"'";
			//어짜피 한번만 쓰니까 변수에 안담음
			stmt.executeUpdate(sql);
		} 
		catch(Exception e){ }
	}

	//delete
	public void deleteuser(String id)
	{
		System.out.println("삭제 함수 진입");
		try 
		{
			//step1 db connect
			Connection conn = DBconn();
			//step2 Query 전송 및 실행
			Statement stmt = conn.createStatement();
			String sql = "delete from member where id='"+id+"'";
			System.out.println("sql은 : "+sql);
			stmt.executeUpdate(sql);
		} 
		catch(Exception e){ }
	}
}
