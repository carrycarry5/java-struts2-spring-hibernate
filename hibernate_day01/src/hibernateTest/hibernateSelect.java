package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.User;
import utils.HibernateUtils;

public class hibernateSelect {
	public static void select(){
		//��ȡsessionFactory
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		//����session����
		Session session = sessionFactory.openSession();
		
		//��������
		Transaction transaction = session.beginTransaction();
		
		//����id��ѯ
		User user = session.get(User.class, 1);
		System.out.println(user);
		
		//�ύ����
		transaction.begin();
		//�ر���Դ
		session.close();
		sessionFactory.close();
	}
}
