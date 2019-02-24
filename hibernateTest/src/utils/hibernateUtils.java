package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtils {
	static SessionFactory sf = null;
	static Configuration cfg  = null;
	
	static{
		cfg = new Configuration();
		cfg.configure();
		sf=cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return sf;
	}
}
