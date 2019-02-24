package hibernateManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Customer;
import entity.LinkMan;
import utils.HibernateUtils;

public class ManyToManyTest {
	//级联保存
	public static void MTMAdd(){
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//开启事务
			transaction = session.beginTransaction();
			
			//具体语句
			//1.在用户，角色的映射文件中的set集合里配置cascade属性：save-update
			//2.创建角色放到用户中，保存角色
			User user1 = new User();
			user1.setName("miku");
			user1.setPassword("39");
			User user2 = new User();
			user2.setName("luck");
			user2.setPassword("45");
			
			Role role1 = new Role();
			role1.setName("carry");
			role1.setMemo("cool");
			Role role2 = new Role();
			role2.setName("nainai");
			role2.setMemo("beauty");
			Role role3 = new Role();
			role3.setName("cat");
			role3.setMemo("cool");
			
			//保存用户
			//user1 ---- role1.role2
			user1.getSetRole().add(role1);
			user1.getSetRole().add(role2);
			//user2 ---- role2,role3
			user2.getSetRole().add(role2);
			user2.getSetRole().add(role3);
			session.save(user1);
			session.save(user2);
			
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
	public static void MTMDelete(){

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//开启事务
			transaction = session.beginTransaction();
			
			//具体语句
			//1.在用户，角色的映射文件中的set集合里配置cascade属性：delete
			//2.获取对象,删除
			User user = session.get(User.class, 2);
			session.delete(user);
			
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

	//维护第三张表
	public static void MTMTable(){

		
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//开启事务
			transaction = session.beginTransaction();
			
			//具体语句
			/*1,用户和角色多对多的关系,维护关系通过第三张表维护
			2.让某个用户拥有某个角色*/
				//1.创建对象
		/*	User user = session.get(User.class, 1);
			Role role = session.get(Role.class, 1);
				//2.把角色放进用户的set集合里
			user.getSetRole().add(role);*/
			//3.让某个用户移除某个角色
				//1.创建对象
			User user = session.get(User.class, 1);
			Role role = session.get(Role.class, 1);
				//2.在用户的set集合里移除角色
			user.getSetRole().remove(role);
			
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
