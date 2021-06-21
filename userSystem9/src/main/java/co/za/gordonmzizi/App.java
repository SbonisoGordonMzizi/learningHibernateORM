package co.za.gordonmzizi;

import co.za.gordonmzizi.persistence.Address;
import co.za.gordonmzizi.persistence.Users;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.MetadataSources;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App 
{
    public static void main( String[] args ) {
        StandardServiceRegistry registry =  null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try{
            registry = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.getTransaction();

            Users user1 = new Users();
            Address user1addr = new Address();
            Users user2 = new Users();
            Address user2addr = new Address();

            user1addr.setStreet("45 lovo");
            user1addr.setCity("Durban");
            user1addr.setCountry("South Africa");
            user1addr.setZipCode(4001);

            user1.setFirstName("Jay");
            user1.setLastName("Brown");
            user1.setAddress(user1addr);

            user2addr.setStreet("55 Long");
            user2addr.setCity("Richmond");
            user2addr.setCountry("South Africa");
            user2addr.setZipCode(1001);

            user2.setFirstName("Vice");
            user2.setLastName("Black");
            user2.setAddress(user2addr);

            transaction.begin();
            session.persist(user1);
            session.persist(user2);
            transaction.commit();
            System.out.println("Transactions Completed");
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
