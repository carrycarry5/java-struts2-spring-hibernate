package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entity.User;
import utils.hibernateUtils;

public class Add {
	public static void add(){
		SessionFactory sf =null;
		Session session =null;
		Transaction transaction =null;
				
		try {
			sf = hibernateUtils.getSessionFactory();
			session = sf.openSession();
			
			//开启事务
			transaction = session.beginTransaction();
			//语句
			User user = new User();
			user.setAge("16");
			user.setName("miku");
			session.save(user);
			
			//提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sf.close();
		}
	}
}
