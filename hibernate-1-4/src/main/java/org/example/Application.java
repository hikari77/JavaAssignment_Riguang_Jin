package org.example;

import org.hibernate.Session;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("start");

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.save(new Student("Bosco", "bosco@email.com"));
        session.save(new Student("Kevin", "kevin@email.com"));
        System.out.println("saved --");

        session.getTransaction().commit();

        session.beginTransaction();

        List<Student> result = session.createQuery( "from Student" ).list();

        for ( Student student : result ) {
            System.out.println( "Student (Id: " + student.getStudentId()+ " - "
                    + student.getName() + ") : "
                    + student.getEmail());
        }
        session.getTransaction().commit();
        session.close();


        HibernateUtil.shutdown();
    }
}
