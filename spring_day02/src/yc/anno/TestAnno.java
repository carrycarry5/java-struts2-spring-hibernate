package yc.anno;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnno {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		User user = (User) context.getBean("user");
		System.out.println(user);
	}
	@After
	public void testservice(){
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		UserService user = (UserService) context.getBean("service");
		user.add();
	}
}
