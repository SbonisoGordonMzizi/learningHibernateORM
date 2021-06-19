package co.za.gordonmzizi;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import co.za.gordonmzizi.domainmodel.Users;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.imageio.spi.ServiceRegistry;


public class App 
{
    public static void main( String[] args ) {
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction =  null;

        try{
            registry = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            Users user1 = new Users();
            user1.setFirstname("Lastlast");
            user1.setLastname("metobro");

            transaction = session.beginTransaction();
            session.persist(user1);
            transaction.commit();
            System.out.println("Transaction Completed");
        }catch (Exception e){
            System.out.println(e.getMessage());
            transaction.rollback();
            StandardServiceRegistryBuilder.destroy(registry);
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
