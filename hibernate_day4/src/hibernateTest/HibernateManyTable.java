package hibernateTest;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Customer;
import entity.LinkMan;
import utils.HibernateUtils;

public class HibernateManyTable {
	//�����Ӳ�ѯ
	public static void select(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//��������
			transaction = session.beginTransaction();
			//���
			//1.������
			/*Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");
			//list�����Ƕ���
			List<LinkMan> list = query.list();*/
			//2.��������
			Query query = session.createQuery("from Customer c left outer join fetch c.setLinkMan");
			List<LinkMan> list  = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//hibernate�ļ�������
	//�����Ӳ�ѯ
	public static void select2(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//��������
			transaction = session.beginTransaction();
			//���
			Customer customer = session.load(Customer.class, 3);
			
			System.out.println(customer.getCid());
			
			System.out.println(customer.getCustMobile());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//����ץȡ
	public static void select3(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//��������
			transaction = session.beginTransaction();
			//���
			//����1(��Ҫ���Ͷ�β�ѯ���)
			Criteria criteria = session.createCriteria(Customer.class);
			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer.getCustName());
				Set<LinkMan> set = customer.getSetLinkMan();
				for (LinkMan linkMan : set) {
					System.out.println(linkMan.getLkm_name());
				}
			}
			//����2,��ʵ���������ļ��е�set��ǩ�ڼ�batch-size,ֵԽ��Ч��Խ����
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
