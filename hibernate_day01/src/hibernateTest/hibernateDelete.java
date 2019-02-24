package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.User;
import utils.HibernateUtils;

public class hibernateDelete {
	public static void delete(){
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Session currentsession = HibernateUtils.getSession();       //获取与本地绑定的session,后面就不需要手动关闭了
		//开启事务
		Transaction transaction = currentsession.beginTransaction();
		
	/*	//删除操作
		//方法1
		User user = session.get(User.class, 3);
		session.delete(user);
		//方法2（少）
		User user = new User();
		user.setUid(1);
		session.delete(user);*/
		
		User user = currentsession.get(User.class, 2);
		currentsession.delete(user);
		//提交事务
		transaction.commit();
		//关闭资源
		session.close();
		sessionFactory.close();
	}
}
