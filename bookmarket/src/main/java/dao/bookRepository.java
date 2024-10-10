package dao;

import java.util.ArrayList;
import dto.book;

public class bookRepository 
{
	private ArrayList<book> listOfBooks = new ArrayList<book>();

	public bookRepository() 
	{
		book book1 = new book("ISBN1234", "C# 프로그래밍", 27000);
		book1.setAuthor("우재남");
		book1.setDescription("");
		book1.setPublisher("한빛아카데미");
		book1.setCategory("IT모바일");
		book1.setUnitsInStock(1000);
		book1.setReleaseDate("2022/10/06");
		
		book book2 = new book("ISBN1235", "자바마스터", 30000);
		book2.setAuthor("송미영");
		book2.setDescription("");
		book2.setPublisher("한빛아카데미");
		book2.setCategory("IT모바일");
		book2.setUnitsInStock(1000);
		book2.setReleaseDate("2023/01/02");
		
		book book3 = new book("ISBN1236", "파이썬 프로그래밍", 30000);
		book3.setAuthor("최성철");
		book3.setDescription("");
		book3.setPublisher("한빛아카데미");
		book3.setCategory("IT모바일");
		book3.setUnitsInStock(1000);
		book3.setReleaseDate("2023/01/01");
		
		listOfBooks.add(book1);
		listOfBooks.add(book2);
		listOfBooks.add(book3);
	}
	
	public ArrayList<book> getAllBooks()
	{
		return listOfBooks;
	}
}
