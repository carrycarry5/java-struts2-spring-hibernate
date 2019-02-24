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
		
		//��������
		Transaction transaction = session.beginTransaction();
		
		//�޸Ĳ���(�Ȳ��ٸ�)
		//1.��ȡ����
		User user=session.get(User.class, 3);
		
		//2.�޸�ֵ
		user.setName("luck");
		//3.ִ���޸Ĳ���
		session.update(user);
		//�ύ����
		transaction.commit();
		//�ر���Դ
		session.close();
		sessionFactory.close();
	}
}
