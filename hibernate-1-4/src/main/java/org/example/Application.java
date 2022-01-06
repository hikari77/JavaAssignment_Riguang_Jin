package org.example;

import org.hibernate.Session;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("start");

        Session session = HibernateUtil.getSessionFactory().openSession();

        // insert
        session.beginTransaction();

        session.save(new Student("Bosco", "bosco@email.com"));
        session.save(new Student("Kevin", "kevin@email.com"));
        System.out.println("saved --");
        session.getTransaction().commit();


        // select
        session.beginTransaction();

        List result = session.createQuery( "from Student" ).list();

        for ( Student student : (List<Student>)result ) {
            System.out.println( "Student (Id: " + student.getStudentId()+ " - "
                    + student.getName() + ") : "
                    + student.getEmail());
        }
        session.getTransaction().commit();


        // update
        session.beginTransaction();

        int updatedEntities = session.createQuery(
                "update Student " +
                        "set email = :newEmail " +
                        "where name = :oldName" )
                .setParameter("oldName", "Bosco")
                .setParameter("newEmail", "new_bosco@email.com")
                .executeUpdate();

        System.out.println("updated: " + updatedEntities);
        session.getTransaction().commit();


        // delete
        session.beginTransaction();

        int deletedRows = session.createQuery(
                "delete Student " +
                        "where name = :name" )
                .setParameter("name", "Kevin")
                .executeUpdate();

        System.out.println("deleted: " + deletedRows);
        session.getTransaction().commit();

        session.close();

        HibernateUtil.shutdown();
    }
}
