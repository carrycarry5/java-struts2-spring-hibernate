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
			//��ȡsessionfactory
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//��������
			transaction = session.beginTransaction();
			
			//���
			//1.����Query����
			Query query =session.createQuery("from User");
			//2.����query������ȡ���ݼ���
			List<User> list = query.list();
			for (User user : list) {
				System.out.println(user);
			}
			
			//�ύ����
			transaction.begin();
		} catch (Exception e) {
			//����ع�
			transaction.rollback();
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
}
