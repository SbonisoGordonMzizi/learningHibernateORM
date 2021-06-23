package co.za.gordonmzizi;

import co.za.gordonmzizi.persistance.Business;
import co.za.gordonmzizi.persistance.Founder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.MetadataSources;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.internal.path.CollectionAttributeJoin;

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

            //Business object
            Business business1 = new Business();
            business1.setBusinessName("WinTop");

            Business business2 = new Business();
            business2.setBusinessName("ClubNight");

            //Founders object
            Founder founder1 = new Founder();
            founder1.setFounderName("Lizi");

            Founder founder2 = new Founder();
            founder2.setFounderName("Juicy");

            //founders and business relationship
            founder1.getBusinesses().add(business1);
            founder1.getBusinesses().add(business2);
            founder2.getBusinesses().add(business1);

            business1.getFounders().add(founder1);
            business1.getFounders().add(founder2);
            business2.getFounders().add(founder1);

            transaction.begin();
            session.persist(founder1);
            session.persist(founder2);

            transaction.commit();
            System.out.println("Transaction Completed");
        }catch (Exception e){
            transaction.rollback();
            StandardServiceRegistryBuilder.destroy(registry);
            System.out.println("Error : "+e.getMessage());

        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
