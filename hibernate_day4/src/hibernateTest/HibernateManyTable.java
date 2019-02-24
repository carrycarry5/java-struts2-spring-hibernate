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
	//内连接查询
	public static void select(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//开启事务
			transaction = session.beginTransaction();
			//语句
			//1.内连接
			/*Query query = session.createQuery("from Customer c inner join fetch c.setLinkMan");
			//list里面是对象
			List<LinkMan> list = query.list();*/
			//2.左外连接
			Query query = session.createQuery("from Customer c left outer join fetch c.setLinkMan");
			List<LinkMan> list  = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//hibernate的检索策略
	//内连接查询
	public static void select2(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//开启事务
			transaction = session.beginTransaction();
			//语句
			Customer customer = session.load(Customer.class, 3);
			
			System.out.println(customer.getCid());
			
			System.out.println(customer.getCustMobile());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//批量抓取
	public static void select3(){
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			//开启事务
			transaction = session.beginTransaction();
			//语句
			//方法1(需要发送多次查询语句)
			Criteria criteria = session.createCriteria(Customer.class);
			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer.getCustName());
				Set<LinkMan> set = customer.getSetLinkMan();
				for (LinkMan linkMan : set) {
					System.out.println(linkMan.getLkm_name());
				}
			}
			//方法2,在实体类配置文件中的set标签内加batch-size,值越大，效果越明显
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
