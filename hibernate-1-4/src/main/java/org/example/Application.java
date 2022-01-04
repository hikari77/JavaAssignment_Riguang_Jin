package org.example;

import org.hibernate.Session;

public class Application {

    public static void main(String[] args) {
        System.out.println("start");

        Session session = HibernateUtil.getSessionFactory().openSession();

        System.out.println(session);

        HibernateUtil.shutdown();
    }
}
