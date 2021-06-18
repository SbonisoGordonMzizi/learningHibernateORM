package co.za.gordonmzizi;

import co.za.gordonmzizi.persistancelayer.Users;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try{
            configuration = new Configuration().configure("hibernate.xml");
            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
            Users user1 = new Users();
            transaction = session.beginTransaction();

            user1.setUserid(100);
            session.delete(user1);
            transaction.commit();
            System.out.println("User "+user1.getUserid()+" is deleted");
        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
