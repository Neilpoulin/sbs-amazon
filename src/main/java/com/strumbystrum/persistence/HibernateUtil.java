package com.strumbystrum.persistence;

import com.strumbystrum.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: neilpoulin
 * Date: 11/12/13
 * Time: 2:24 AM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            Configuration cfg = new Configuration().configure();
            cfg.addAnnotatedClass(User.class);
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(cfg.getProperties()).buildServiceRegistry();


            // Create the SessionFactory from hibernate.cfg.xml
            return cfg.buildSessionFactory(serviceRegistry);
        }
        catch (Throwable ex)
        {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static void shutdown()
    {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
