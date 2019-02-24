package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import entity.User;
import utils.HibernateUtils;

public class hibernateAdd {
		

	public static void add(){
/*//		��һ��������hibernate���������ļ�
			//��src����һ����hibernate.cfg.xml���ļ�
		Configuration cfg = new Configuration();
		cfg.configure();
		
//		�ڶ���������sessionFactory����
			//��ȡhibernate���������ļ����ݣ�����sessionFactory
			//�ڹ����У�����ӳ���ϵ���������ݿ��аѱ���
			//����������ر�������Դ������һ����Ŀ����һ��sessionFactory����
			//�����������һ��utils����ʵ�ֵ�һ���͵ڶ���
		SessionFactory sessionFactory = cfg.buildSessionFactory();*/
		
//		��������ͨ��sessionFactory���󴴽�session����
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
//		���Ĳ�����������
		Transaction transaction = session.beginTransaction();	
		
//		���岽��д�����߼�crud����
		//����session��ͬ�ķ�������crud����
		//��1����� save
		//��2������ update
		//��3��ɾ�� delete
		//��4������id��ѯ get
		
		//sessionΪ���̶߳��󣨲��ܹ��ã�
			//	��ӹ���
		User user = new User();
		user.setAddress("�й�");
		user.setName("�����");
		user.setPassword("��ɵ��");
			//����session�ķ���ִ�����
		session.save(user);
//		���������ύ����
		transaction.commit();
		
//		���߲����ر���Դ
		session.close();
		sessionFactory.close();
	}
}






