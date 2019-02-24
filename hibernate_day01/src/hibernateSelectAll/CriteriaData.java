package hibernateSelectAll;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.User;
import utils.HibernateUtils;

public class CriteriaData {
	public static void criteriaData(){
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
			//1.获取criteria对象
			Criteria criteria  = session.createCriteria(User.class);
			//2.调用方法获取list
			List<User> list = criteria.list();
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
