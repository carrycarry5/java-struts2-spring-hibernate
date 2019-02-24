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
		Session currentsession = HibernateUtils.getSession();       //��ȡ�뱾�ذ󶨵�session,����Ͳ���Ҫ�ֶ��ر���
		//��������
		Transaction transaction = currentsession.beginTransaction();
		
	/*	//ɾ������
		//����1
		User user = session.get(User.class, 3);
		session.delete(user);
		//����2���٣�
		User user = new User();
		user.setUid(1);
		session.delete(user);*/
		
		User user = currentsession.get(User.class, 2);
		currentsession.delete(user);
		//�ύ����
		transaction.commit();
		//�ر���Դ
		session.close();
		sessionFactory.close();
	}
}
