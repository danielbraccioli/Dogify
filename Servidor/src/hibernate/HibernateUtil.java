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

			config.addAnnotatedClass(UsuarioEntity.class);
			config.addAnnotatedClass(ClienteEntity.class);
			config.addAnnotatedClass(PaseadorEntity.class);
			config.addAnnotatedClass(CalificacionEntity.class);
			config.addAnnotatedClass(DireccionEntity.class);
			config.addAnnotatedClass(EfectivoEntity.class);
			config.addAnnotatedClass(MensajeEntity.class);
			config.addAnnotatedClass(MercadoPagoEntity.class);
			config.addAnnotatedClass(PagoEntity.class);
			config.addAnnotatedClass(PaseoEntity.class);
			config.addAnnotatedClass(PerroEntity.class);
			config.addAnnotatedClass(ReservaEntity.class);
			config.addAnnotatedClass(FotoEntity.class);
			
			sessionFactory = config.buildSessionFactory();
			session = sessionFactory.openSession();
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
