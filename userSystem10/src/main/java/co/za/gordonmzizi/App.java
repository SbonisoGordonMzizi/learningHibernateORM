package co.za.gordonmzizi;

import co.za.gordonmzizi.persistence.Users;
import co.za.gordonmzizi.persistence.Address;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class App{
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


            Address user1Addr1 = new Address();
            Address user1Addr2 = new Address();
            Users user1 = new Users();

            user1Addr1.setStreet("34 Lovo");
            user1Addr1.setCity("Durban");
            user1Addr1.setCountry("South Africa");
            user1Addr1.setZipcode(4001);

            user1Addr2.setStreet("11 Fox");
            user1Addr2.setCity("Spring");
            user1Addr2.setCountry("South Africa");
            user1Addr2.setZipcode(1001);




            user1.setFirstName("Bob");
            user1.setLastName("Smith");
            user1.getAddresses().add(user1Addr1);
            user1.getAddresses().add(user1Addr2);

            transaction.begin();
            session.persist(user1);
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
