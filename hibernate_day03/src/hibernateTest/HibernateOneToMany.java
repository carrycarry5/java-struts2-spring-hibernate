package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Customer;
import entity.LinkMan;
import utils.HibernateUtils;

public class HibernateOneToMany {
	//级联保存2
	public static void add2(){
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//开启事务
			transaction = session.beginTransaction();
			
			//具体语句
			/*一般根据客户添加联系人
			第一步：在客户配置文件中配置： <set name="setLinkMan" cascade="save-update">*/
			//第二步：创建客户和联系人对象，只需要把联系人放到客户对象的set集合中就可以了，最终只需要保存客户
			//1.创建一个客户，为这个客户添加联系人
			Customer customer = new Customer( "客户", "一级", "百度", "1234567", "12345678910");
			LinkMan linkMan = new LinkMan( "联系人", "男", "222222222");
			//2把联系人对象，放进客户对象的set集合中
			customer.getSetLinkMan().add(linkMan);
			//3.保存对象
			session.save(customer);
			
			//执行事务
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	//级联保存1
	public static void add1(){

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//开启事务
			transaction = session.beginTransaction();
			
			//具体语句
			//1.创建一个客户，为这个客户添加联系人
				Customer customer = new Customer( "客户", "一级", "百度", "1234567", "12345678910");
				LinkMan linkMan = new LinkMan( "联系人", "男", "222222222");
			//2.在客户表示联系人，在联系人表示客户
				//2.1把联系人对象，放进客户对象的set集合中
				customer.getSetLinkMan().add(linkMan);
				//2.2把客户对象，放进联系人对象中
				linkMan.setCustomer(customer);
			//3.保存
				session.save(linkMan);
				session.save(customer);
				
			//执行事务
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	//级联删除
	public static void delete(){

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//开启事务
			transaction = session.beginTransaction();
			
			//具体语句
			//级联删除，删除某个客户，把客户里所有联系人删除
			//第一步，在客户映射文件中进行配置：<set name="setLinkMan" cascade="save-update，delete">
			//第二步，根据id查询客户对象，调用session的delete对象进行删除；
			Customer customer = new Customer();
			customer = session.get(Customer.class,1);
			session.delete(customer);
		
				
			//执行事务
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	//修改操作
	public static void update(){

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//开启事务
			transaction = session.beginTransaction();
			
			//具体语句
			//根据id查询两个对象
			Customer customer = session.get(Customer.class, 3);
			LinkMan linkMan = session.get(LinkMan.class, 3);
			//2.1把联系人对象，放进客户对象的set集合中
			customer.getSetLinkMan().add(linkMan);
			//2.2把客户对象，放进联系人对象中
			linkMan.setCustomer(customer);
				
			//执行事务
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
