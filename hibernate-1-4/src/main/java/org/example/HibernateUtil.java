package org.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            if (sessionFactory == null) {
                synchronized (SessionFactory.class) {
                    if (sessionFactory == null) {
                         StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                                .configure() // configures settings from hibernate.cfg.xml
                                .build();
                        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                    }
                    return sessionFactory;
                }
            }
            return sessionFactory;
        } catch (Exception ex) {
            throw ex;
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
