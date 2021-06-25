package co.za.gordonmzizi.view;

import co.za.gordonmzizi.persistance.Person;
import co.za.gordonmzizi.persistance.Parent;
import co.za.gordonmzizi.persistance.Teacher;
import co.za.gordonmzizi.persistance.Student;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.MetadataSources;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Session;


public class App {
    public static void main( String[] args ) {
        StandardServiceRegistry registry = null;
        SessionFactory sessionfactory = null;
        Session session = null;
        Transaction transaction = null;

        try{
            registry = new StandardServiceRegistryBuilder().configure().build();
            sessionfactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionfactory.openSession();
            transaction = session.getTransaction();

            Parent parentForSteve = new Parent();
            parentForSteve.setFirstName("Bob");
            parentForSteve.setSecondName("Tank");
            parentForSteve.setLastName("Smith");
            parentForSteve.setGender("Male");
            parentForSteve.setAge(38);
            parentForSteve.setPersonType("Parent");

            Teacher teacherMath = new Teacher();
            teacherMath.setFirstName("Ice");
            teacherMath.setSecondName("Luzy");
            teacherMath.setLastName("White");
            teacherMath.setGender("Female");
            teacherMath.setAge(32);
            teacherMath.setPersonType("Teacher");

            Student studentSteve = new Student();
            studentSteve.setFirstName("Steve");
            studentSteve.setSecondName("molly");
            studentSteve.setLastName("Smith");
            studentSteve.setGender("Male");
            studentSteve.setAge(12);
            studentSteve.setPersonType("Student");

            transaction.begin();
            session.persist(parentForSteve);
            session.persist(studentSteve);
            session.persist(teacherMath);
            transaction.commit();
            System.out.println("Transaction Completed");

        }catch (Exception e){
            transaction.rollback();
            StandardServiceRegistryBuilder.destroy(registry);
            System.out.println("Error : "+e.getMessage());
        }finally {
            session.close();
            sessionfactory.close();
        }

    }
}
