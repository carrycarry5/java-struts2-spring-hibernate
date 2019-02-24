package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.User;
import utils.HibernateUtils;

public class hibernateSelect {
	public static void select(){
		//获取sessionFactory
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//创建session对象
		Session session = sessionFactory.openSession();
		
		//开启事务
		Transaction transaction = session.beginTransaction();
		
		//根据id查询
		User user = session.get(User.class, 1);
		System.out.println(user);
		
		//提交事务
		transaction.begin();
		//关闭资源
		session.close();
		sessionFactory.close();
	}
}
