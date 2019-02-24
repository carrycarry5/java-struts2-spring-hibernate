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
			//��ȡsessionfactory
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//��������
			transaction = session.beginTransaction();
			
			//���
			//1.��ȡcriteria����
			Criteria criteria  = session.createCriteria(User.class);
			//2.���÷�����ȡlist
			List<User> list = criteria.list();
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
