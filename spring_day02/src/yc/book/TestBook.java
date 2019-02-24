package yc.book;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
	
	@Test
	public void  booktest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		BookService bookService = (BookService) context.getBean("BookService");
		bookService.add();
	}
}
