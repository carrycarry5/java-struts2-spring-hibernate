package yc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	@Test
	public void testaop(){
		ApplicationContext context  = new ClassPathXmlApplicationContext("bean1.xml");
		Book book = (Book) context.getBean("book");
		book.add();
	}
}
