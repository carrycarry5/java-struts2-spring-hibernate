
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
	//对象导航查询
	public static void select1(){
		SessionFactory sessionFactory = null;
		Session session  = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session  = sessionFactory.openSession();
			//开启事务
			transaction = session.beginTransaction();
			//具体语句
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
	//hql查询
	public static void select2(){
		SessionFactory sessionFactory = null;
		Session session  = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session  = sessionFactory.openSession();
			//开启事务
			transaction = session.beginTransaction();
			//具体语句
			
			//1.查询所有
			/*Query query = session.createQuery("from LinkMan");
			List<LinkMan> list = query.list();
			for (LinkMan linkMan : list) {
				System.out.println(linkMan);
			}*/
			
			//2.条件查询
			/*Query query = session.createQuery("from LinkMan L where L.lkm_id=? and L.lkm_name=?");
			query.setParameter(0, 1);
			query.setParameter(1, "李彦宏");
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

	//QBC Criteria查询 (条件查询)
	public static void select3(){
		SessionFactory sessionFactory = null;
		Session session  = null;
		Transaction transaction = null;
		List<LinkMan> list = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session  = sessionFactory.openSession();
			//开启事务
			transaction = session.beginTransaction();
			//具体语句
			Criteria criteria = session.createCriteria(LinkMan.class);
			//1.排序查询
			/*
			criteria.addOrder(Order.desc("lkm_id"));
			List<LinkMan> list = criteria.list();
			*/
			
			//2.分页操作
			/*	//设置开始位置
			criteria.setFirstResult(2);
				//设置每页记录数
			criteria.setMaxResults(2);*/
			
			/*//3.统计查询
			criteria.setProjection(Projections.rowCount());
			Object obj = criteria.uniqueResult();
			Long long1 = (Long) obj;
			int count = long1.intValue();
			
			int a= Integer.parseInt(obj.toString());
			System.out.println(count);
			System.out.println(a);*/
			
			//4.离线查询(可以不用session对象)
			DetachedCriteria detachedCriteria  = DetachedCriteria.forClass(LinkMan.class);
				//最终执行时才需要session
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
