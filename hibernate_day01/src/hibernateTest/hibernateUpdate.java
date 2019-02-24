package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.User;
import utils.HibernateUtils;

public class hibernateUpdate {
	public static void update(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		//修改操作(先查再改)
		//1.获取对象
		User user=session.get(User.class, 3);
		
		//2.修改值
		user.setName("luck");
		//3.执行修改操作
		session.update(user);
		//提交事务
		transaction.commit();
		//关闭资源
		session.close();
		sessionFactory.close();
	}
}
