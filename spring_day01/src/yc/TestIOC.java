package yc;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import duixiang.userDao;
import duixiang.userService;
import ycproperty.Book;
import ycproperty.Person;
import ycproperty.propertyDemo1;

public class TestIOC {
	@Test
	public void t (){
		//1.����spring�����ļ������ݴ�������
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		//2.�õ����ô����Ķ���
		User user = (User) context.getBean("user");
		System.out.println(user);
		user.add();
		user.setName("С��");
		System.out.println(user.getName());
		User user2 = (User) context.getBean("user");
		System.out.println(user2.getName());
	}
	@Test
	public void test11(){
		ApplicationContext context  = new ClassPathXmlApplicationContext("bean1.xml");
		propertyDemo1 p = (propertyDemo1) context.getBean("demo1");
		p.test1();
	}
	
	@Test
	public void bookTest(){
		ApplicationContext context  = new ClassPathXmlApplicationContext("bean1.xml");
		Book book = (Book) context.getBean("book");
		book.test();
	}
	
	@Test
	public void daoTest(){
		ApplicationContext context  = new ClassPathXmlApplicationContext("bean1.xml");
		userService service = (userService) context.getBean("service");
		service.add();
	}
	
	@After
	public void personTest(){
		ApplicationContext context  = new ClassPathXmlApplicationContext("bean1.xml");
		Person person = (Person) context.getBean("person");
		person.test();
	}
}
