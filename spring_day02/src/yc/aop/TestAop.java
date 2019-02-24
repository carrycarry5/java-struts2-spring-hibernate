package yc.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	@Test
	public void aopTest(){
		ApplicationContext context  = new ClassPathXmlApplicationContext("bean3.xml");
		Book book1 = (Book) context.getBean("book");
		book1.add();
	}
}
