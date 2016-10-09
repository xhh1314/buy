package buy.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory=buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		// TODO Auto-generated method stub
		try{
			Configuration cfg = new Configuration().configure();

			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			        .applySettings(cfg.getProperties()).build();

			return cfg.buildSessionFactory(serviceRegistry);
		//return new Configuration().configure().buildSessionFactory(new StandardServiceRegistryBuilder().build());
		}
		catch(Throwable ex){
			System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	

}
