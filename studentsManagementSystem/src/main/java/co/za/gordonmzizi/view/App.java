package co.za.gordonmzizi.view;

import co.za.gordonmzizi.persistance.*;
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

            //person objects
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

            // address objects
            Address steveAddress = new Address();
            steveAddress.setStreet("123 King long");
            steveAddress.setCity("East Rand");
            steveAddress.setProvince("Gautang");
            steveAddress.setCountry("South Africa");
            steveAddress.setZipCode(3123);
            studentSteve.setAddress(steveAddress);

            Address parentAddress = new Address();
            parentAddress.setStreet("123 King long");
            parentAddress.setCity("East Rand");
            parentAddress.setProvince("Gautang");
            parentAddress.setCountry("South Africa");
            parentAddress.setZipCode(3123);
            parentForSteve.setAddress(parentAddress);

            Address teacherAddress = new Address();
            teacherAddress.setStreet("992 west");
            teacherAddress.setCity("springs");
            teacherAddress.setProvince("Gautang");
            teacherAddress.setCountry("South Africa");
            teacherAddress.setZipCode(3123);
            teacherMath.setAddress(teacherAddress);

            //Contact objects
            Contact parentContact = new Contact();
            parentContact.setCellNo("0724375874");
            parentContact.setPhoneNo("0311123097");
            parentContact.setEmail("bobsmith@jobme.com");
            parentForSteve.setContact(parentContact);

            Contact teacherContact = new Contact();
            teacherContact.setCellNo("0811234567");
            teacherContact.setPhoneNo("031 6764383");
            teacherContact.setEmail("icewhite@school.com");
            teacherMath.setContact(teacherContact);

            Contact steveContact = new Contact();
            steveContact.setCellNo("0712345621");
            steveContact.setPhoneNo("0110923324");
            steveContact.setEmail("stevesmith@jobme.com");
            studentSteve.setContact(steveContact);

            //parent,student and teacher relationship
            parentForSteve.getStudents().add(studentSteve);
            studentSteve.setParent(parentForSteve);
            studentSteve.getTeachers().add(teacherMath);
            teacherMath.getStudents().add(studentSteve);


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
