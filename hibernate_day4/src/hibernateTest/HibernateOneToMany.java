package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Customer;
import entity.LinkMan;
import utils.HibernateUtils;

public class HibernateOneToMany {
	//��������2
	public static void add2(){
		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//��������
			transaction = session.beginTransaction();
			
			//�������
			/*һ����ݿͻ������ϵ��
			��һ�����ڿͻ������ļ������ã� <set name="setLinkMan" cascade="save-update">*/
			//�ڶ����������ͻ�����ϵ�˶���ֻ��Ҫ����ϵ�˷ŵ��ͻ������set�����оͿ����ˣ�����ֻ��Ҫ����ͻ�
			//1.����һ���ͻ���Ϊ����ͻ������ϵ��
			Customer customer = new Customer( "�ͻ�", "һ��", "�ٶ�", "1234567", "12345678910");
			LinkMan linkMan = new LinkMan( "��ϵ��", "��", "222222222");
			//2����ϵ�˶��󣬷Ž��ͻ������set������
			customer.getSetLinkMan().add(linkMan);
			//3.�������
			session.save(customer);
			
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
	//��������1
	public static void add1(){

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//��������
			transaction = session.beginTransaction();
			
			//�������
			//1.����һ���ͻ���Ϊ����ͻ������ϵ��
				Customer customer = new Customer( "�ͻ�", "һ��", "�ٶ�", "1234567", "12345678910");
				LinkMan linkMan = new LinkMan( "��ϵ��", "��", "222222222");
			//2.�ڿͻ���ʾ��ϵ�ˣ�����ϵ�˱�ʾ�ͻ�
				//2.1����ϵ�˶��󣬷Ž��ͻ������set������
				customer.getSetLinkMan().add(linkMan);
				//2.2�ѿͻ����󣬷Ž���ϵ�˶�����
				linkMan.setCustomer(customer);
			//3.����
				session.save(linkMan);
				session.save(customer);
				
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
	public static void delete(){

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//��������
			transaction = session.beginTransaction();
			
			//�������
			//����ɾ����ɾ��ĳ���ͻ����ѿͻ���������ϵ��ɾ��
			//��һ�����ڿͻ�ӳ���ļ��н������ã�<set name="setLinkMan" cascade="save-update��delete">
			//�ڶ���������id��ѯ�ͻ����󣬵���session��delete�������ɾ����
			Customer customer = new Customer();
			customer = session.get(Customer.class,1);
			session.delete(customer);
		
				
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
	//�޸Ĳ���
	public static void update(){

		Session session = null;
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			
			//��������
			transaction = session.beginTransaction();
			
			//�������
			//����id��ѯ��������
			Customer customer = session.get(Customer.class, 3);
			LinkMan linkMan = session.get(LinkMan.class, 3);
			//2.1����ϵ�˶��󣬷Ž��ͻ������set������
			customer.getSetLinkMan().add(linkMan);
			//2.2�ѿͻ����󣬷Ž���ϵ�˶�����
			linkMan.setCustomer(customer);
				
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
