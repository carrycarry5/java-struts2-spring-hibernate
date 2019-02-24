package hibernateSelectAll;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.User;
import utils.HibernateUtils;

public class QueryData {
	public static void quaryData(){
		Session  session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			//获取sessionfactory
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//开启事务
			transaction = session.beginTransaction();
			
			//语句
			//1.创建Query对象
			Query query =session.createQuery("from User");
			//2.调用query方法获取数据集合
			List<User> list = query.list();
			for (User user : list) {
				System.out.println(user);
			}
			
			//提交事务
			transaction.begin();
		} catch (Exception e) {
			//事务回滚
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
}
