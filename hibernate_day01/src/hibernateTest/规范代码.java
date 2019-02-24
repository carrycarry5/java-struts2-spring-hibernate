package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import utils.HibernateUtils;

public class �淶���� {
	public static void �淶�Ĵ���(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//��������
			transaction = session.beginTransaction();
			//ִ�в���
			
			//�ύ����
			transaction.commit();
		} catch (Exception e) {
			//�ع�
			transaction.rollback();
			e.printStackTrace();
		} finally{
			session.close();
			sessionFactory.close();
		}
	}
}
