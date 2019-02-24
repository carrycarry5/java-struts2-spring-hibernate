
package hibernateTest;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Expression;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.mysql.jdbc.log.Log;

import entity.Customer;
import entity.LinkMan;
import utils.HibernateUtils;

public class HibernateSelect {
	//���󵼺���ѯ
	public static void select1(){
		SessionFactory sessionFactory = null;
		Session session  = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session  = sessionFactory.openSession();
			//��������
			transaction = session.beginTransaction();
			//�������
			Customer customer = session.get(Customer.class, 3);
			Set<LinkMan> linkMans = customer.getSetLinkMan();
			for (LinkMan linkMan : linkMans) {
				System.out.println(linkMan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	//hql��ѯ
	public static void select2(){
		SessionFactory sessionFactory = null;
		Session session  = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session  = sessionFactory.openSession();
			//��������
			transaction = session.beginTransaction();
			//�������
			
			//1.��ѯ����
			/*Query query = session.createQuery("from LinkMan");
			List<LinkMan> list = query.list();
			for (LinkMan linkMan : list) {
				System.out.println(linkMan);
			}*/
			
			//2.������ѯ
			/*Query query = session.createQuery("from LinkMan L where L.lkm_id=? and L.lkm_name=?");
			query.setParameter(0, 1);
			query.setParameter(1, "�����");
			List<LinkMan> list = query.list();
			for (LinkMan linkMan : list) {
				System.out.println(linkMan);
			}*/
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	//QBC Criteria��ѯ (������ѯ)
	public static void select3(){
		SessionFactory sessionFactory = null;
		Session session  = null;
		Transaction transaction = null;
		List<LinkMan> list = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session  = sessionFactory.openSession();
			//��������
			transaction = session.beginTransaction();
			//�������
			Criteria criteria = session.createCriteria(LinkMan.class);
			//1.�����ѯ
			/*
			criteria.addOrder(Order.desc("lkm_id"));
			List<LinkMan> list = criteria.list();
			*/
			
			//2.��ҳ����
			/*	//���ÿ�ʼλ��
			criteria.setFirstResult(2);
				//����ÿҳ��¼��
			criteria.setMaxResults(2);*/
			
			/*//3.ͳ�Ʋ�ѯ
			criteria.setProjection(Projections.rowCount());
			Object obj = criteria.uniqueResult();
			Long long1 = (Long) obj;
			int count = long1.intValue();
			
			int a= Integer.parseInt(obj.toString());
			System.out.println(count);
			System.out.println(a);*/
			
			//4.���߲�ѯ(���Բ���session����)
			DetachedCriteria detachedCriteria  = DetachedCriteria.forClass(LinkMan.class);
				//����ִ��ʱ����Ҫsession
			criteria = detachedCriteria.getExecutableCriteria(session);
			
			
			
			list = criteria.list();
			for (LinkMan linkMan : list) {
				System.out.println(linkMan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
