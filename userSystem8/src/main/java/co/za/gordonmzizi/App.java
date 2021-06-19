package co.za.gordonmzizi;

import co.za.gordonmzizi.persistencelayer.Users;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.MetadataSources;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;



import java.util.List;

public class App {
    public static void main( String[] args ) {
        StandardServiceRegistry registry = null;
        SessionFactory sessionFactory = null;
        Session session =  null;
        Transaction transaction = null;

        try{
            registry = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            List result = session.createQuery("from Users ").list();
            for(Users user : (List<Users>)result){
                System.out.println(user.getUserid()+" "+user.getFirstname()+" "+user.getLastname());
            }
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
