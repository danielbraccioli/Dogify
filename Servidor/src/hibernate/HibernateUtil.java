package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entity.*;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	private static Session session;

	static {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();

		//	config.addAnnotatedClass(AlmacenEntity.class);

		//	sessionFactory = config.buildSessionFactory();
		//	session = sessionFactory.openSession();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		return session;
	}

}
