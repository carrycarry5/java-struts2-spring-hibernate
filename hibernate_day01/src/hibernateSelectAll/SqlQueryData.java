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
			//��ȡsessionfactory
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//��������
			transaction = session.beginTransaction();
			
			//���
			/*//1.��ȡSQLQuery����
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
			//2.����list���ϣ�Ĭ��Ϊ����
			List<Object[]> list = sqlQuery.list();
			for (Object[] object : list) {
				System.out.println(Arrays.toString(object));
			}*/
			
			//ʹ����list������ÿ���ֶ���ʵ�������
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
			sqlQuery.addEntity(User.class);
			List<User> list  = sqlQuery.list();
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
