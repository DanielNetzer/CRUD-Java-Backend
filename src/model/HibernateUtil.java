package model;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	
	private static Configuration configuration;
	private static ServiceRegistry serviceRegistry;
    private static final SessionFactory sessionFactory;
    
    static {
        try {            
        	Configuration configuration = new Configuration();
        	configuration.configure();
        	serviceRegistry = new ServiceRegistryBuilder().applySettings(
        	configuration.getProperties()). buildServiceRegistry();
        	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
