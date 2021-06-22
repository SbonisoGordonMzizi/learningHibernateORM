package co.za.gordonmzizi;

import co.za.gordonmzizi.persistence.Person;
import co.za.gordonmzizi.persistence.Car;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.MetadataSources;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {
    public static void main( String[] args ) {
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try{
            registry = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.getTransaction();
            Car car1 = new Car();
            car1.setCarName("Toyota");

            Person person1 = new Person();
            person1.setFirstName("Vice");
            person1.setCar(car1);
            car1.setPerson(person1);

            transaction.begin();
            session.save(person1);
            session.save(car1);
            transaction.commit();
            System.out.println("Transaction Completed");


        }catch (Exception e){
            System.out.println("Error : "+e.getMessage());
            transaction.rollback();
            StandardServiceRegistryBuilder.destroy(registry);
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
