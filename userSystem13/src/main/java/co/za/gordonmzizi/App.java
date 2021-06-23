package co.za.gordonmzizi;

import co.za.gordonmzizi.persistance.Founder;
import co.za.gordonmzizi.persistance.Business;
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

            Business business1 = new Business();
            business1.setBusinessName("TechCrete");
            Business business2 = new Business();
            business2.setBusinessName("ClubLocator");

            Founder founder1 = new Founder();
            Founder founder2 = new Founder();
            founder1.setFounderName("Bob");
            founder2.setFounderName("Lisa");

            business1.getFounders().add(founder1);
            business1.getFounders().add(founder2);
            business2.getFounders().add(founder1);

            founder1.getBusinesses().add(business1);
            founder1.getBusinesses().add(business2);
            founder2.getBusinesses().add(business1);

            transaction.begin();
            session.persist(founder1);
            session.persist(founder2);
            session.persist(business1);
            session.persist(business2);
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
