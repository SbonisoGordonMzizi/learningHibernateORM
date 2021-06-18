package co.za.gordonmzizi;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class App 
{
    public static void main( String[] args ) throws Exception {
       Configuration configuration = null;
       SessionFactory sessionFactory = null;
       Session session = null;
       Transaction transaction = null;

       try{
           configuration = new Configuration().configure();
           sessionFactory = configuration.buildSessionFactory();
           session = sessionFactory.openSession();

           Users user1 = new Users();
           transaction = session.beginTransaction();
           user1.setUserid(101);
           user1.setFirstname("Bob");
           user1.setLastname("Smith");
           session.persist(user1);
           transaction.commit();
           System.out.println("Successful added User "+user1.getFirstname());
       }catch (Exception e){
           transaction.rollback();
           System.out.println(e.getMessage());
       }finally {
           session.close();
           sessionFactory.close();
       }

    }
}
