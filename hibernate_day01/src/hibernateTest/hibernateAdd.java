package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import entity.User;
import utils.HibernateUtils;

public class hibernateAdd {
		

	public static void add(){
/*//		第一步：加载hibernate核心配置文件
			//到src下找一个叫hibernate.cfg.xml的文件
		Configuration cfg = new Configuration();
		cfg.configure();
		
//		第二步：创建sessionFactory对象
			//读取hibernate核心配置文件内容，创建sessionFactory
			//在过程中，根据映射关系在配置数据库中把表创建
			//这个过程中特别消耗资源，建议一个项目创建一个sessionFactory对象
			//具体操作：建一个utils类来实现第一步和第二步
		SessionFactory sessionFactory = cfg.buildSessionFactory();*/
		
//		第三步：通过sessionFactory对象创建session对象
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		
//		第四步：开启事务
		Transaction transaction = session.beginTransaction();	
		
//		第五步：写具体逻辑crud操作
		//调用session不同的方法进行crud操作
		//（1）添加 save
		//（2）更新 update
		//（3）删除 delete
		//（4）根据id查询 get
		
		//session为单线程对象（不能共用）
			//	添加功能
		User user = new User();
		user.setAddress("中国");
		user.setName("吴洪涛");
		user.setPassword("大傻逼");
			//调用session的方法执行添加
		session.save(user);
//		第六步：提交事务
		transaction.commit();
		
//		第七步：关闭资源
		session.close();
		sessionFactory.close();
	}
}






