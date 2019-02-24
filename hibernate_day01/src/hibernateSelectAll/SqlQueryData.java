package hibernateSelectAll;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.User;
import utils.HibernateUtils;

public class SqlQueryData {
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
			/*//1.获取SQLQuery对象
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
			//2.返回list集合，默认为数组
			List<Object[]> list = sqlQuery.list();
			for (Object[] object : list) {
				System.out.println(Arrays.toString(object));
			}*/
			
			//使返回list集合中每部分都是实体类对象
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
			sqlQuery.addEntity(User.class);
			List<User> list  = sqlQuery.list();
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
