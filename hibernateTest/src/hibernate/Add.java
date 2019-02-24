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
			
			//��������
			transaction = session.beginTransaction();
			//���
			User user = new User();
			user.setAge("16");
			user.setName("miku");
			session.save(user);
			
			//�ύ����
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sf.close();
		}
	}
}
