package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utils.HibernateUtils;

public class 规范代码 {
	public static void 规范的代码(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//开启事务
			transaction = session.beginTransaction();
			//执行操作
			
			//提交事务
			transaction.commit();
		} catch (Exception e) {
			//回滚
			transaction.rollback();
			e.printStackTrace();
		} finally{
			session.close();
			sessionFactory.close();
		}
	}
}
