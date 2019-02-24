package ycproperty;

import org.junit.Test;

public class Book {
	private String bookname;

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	@Test
	public void test(){
		System.out.println("bookname:........."+bookname);
	}
}
