package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	static  Configuration cfg =null;
	static  SessionFactory sf = null;
	//��̬�����ʵ��
	static{
//		��һ��������hibernate���������ļ�
		//��src����һ����hibernate.cfg.xml���ļ�
		 cfg = new Configuration();
		cfg.configure();
//		�ڶ���������sessionFactory����
			//��ȡhibernate���������ļ����ݣ�����sessionFactory
			//�ڹ����У�����ӳ���ϵ���������ݿ��аѱ���
		sf = cfg.buildSessionFactory();
	}
	
	//�ṩ��������sessionFactory
	public static SessionFactory getSessionFactory(){
		return sf;
		
	}
	//�ṩ���������뱾���̰߳󶨵�session
	public static Session getSession(){
		return sf.getCurrentSession();
	}

	
}
