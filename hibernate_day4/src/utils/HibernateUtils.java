package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	static  Configuration cfg =null;
	static  SessionFactory sf = null;
	//静态代码块实现
	static{
//		第一步：加载hibernate核心配置文件
		//到src下找一个叫hibernate.cfg.xml的文件
		 cfg = new Configuration();
		cfg.configure();
//		第二步：创建sessionFactory对象
			//读取hibernate核心配置文件内容，创建sessionFactory
			//在过程中，根据映射关系在配置数据库中把表创建
		sf = cfg.buildSessionFactory();
	}
	
	//提供方法返回sessionFactory
	public static SessionFactory getSessionFactory(){
		return sf;
		
	}
	//提供方法返回与本地线程绑定的session
	public static Session getSession(){
		return sf.getCurrentSession();
	}

	
}
