package hibernateManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Customer;
import entity.LinkMan;
import utils.HibernateUtils;

public class ManyToManyTest {
	//��������
	public static void MTMAdd(){
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//��������
			transaction = session.beginTransaction();
			
			//�������
			//1.���û�����ɫ��ӳ���ļ��е�set����������cascade���ԣ�save-update
			//2.������ɫ�ŵ��û��У������ɫ
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
			
			//�����û�
			//user1 ---- role1.role2
			user1.getSetRole().add(role1);
			user1.getSetRole().add(role2);
			//user2 ---- role2,role3
			user2.getSetRole().add(role2);
			user2.getSetRole().add(role3);
			session.save(user1);
			session.save(user2);
			
			//ִ������
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	//����ɾ��
	public static void MTMDelete(){

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//��������
			transaction = session.beginTransaction();
			
			//�������
			//1.���û�����ɫ��ӳ���ļ��е�set����������cascade���ԣ�delete
			//2.��ȡ����,ɾ��
			User user = session.get(User.class, 2);
			session.delete(user);
			
			//ִ������
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

	//ά�������ű�
	public static void MTMTable(){

		
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//��������
			transaction = session.beginTransaction();
			
			//�������
			/*1,�û��ͽ�ɫ��Զ�Ĺ�ϵ,ά����ϵͨ�������ű�ά��
			2.��ĳ���û�ӵ��ĳ����ɫ*/
				//1.��������
		/*	User user = session.get(User.class, 1);
			Role role = session.get(Role.class, 1);
				//2.�ѽ�ɫ�Ž��û���set������
			user.getSetRole().add(role);*/
			//3.��ĳ���û��Ƴ�ĳ����ɫ
				//1.��������
			User user = session.get(User.class, 1);
			Role role = session.get(Role.class, 1);
				//2.���û���set�������Ƴ���ɫ
			user.getSetRole().remove(role);
			
			//ִ������
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
