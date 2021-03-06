package util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateSessionFactory {
	private static String configFile = "/hibernate.cfg.xml";
	private static Configuration config = new Configuration();
	private static SessionFactory sessionFactory = null;
	
	private static final ThreadLocal<Session> t = new ThreadLocal<Session>();
	
	static{
		try {
			config.configure(configFile);
			sessionFactory = config.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public static Session getSession() throws HibernateException{
		Session session = t.get();
		if(session == null || !session.isOpen()){
			if(sessionFactory == null){
				rebuildSessionFactory();
			}
			session = (sessionFactory!=null) ? sessionFactory.openSession() : null;
			t.set(session);
		}
		return session;
	}

	private static void rebuildSessionFactory() {
		try {
			   config.configure(configFile);
			   sessionFactory = config.buildSessionFactory();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
	}
	
	public static void closeSession() throws HibernateException{
		Session session = t.get();
		t.set(null);
		if(session!=null){
			session.close();
		}
	}
}
