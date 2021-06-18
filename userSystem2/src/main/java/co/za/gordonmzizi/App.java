package co.za.gordonmzizi;
import  co.za.gordonmzizi.persistencelayer.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = null;
        Session session = null;
        Transaction transaction = null;
        SessionFactory sessionFactory = null;

        try{
            configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
            Users user1 = new Users();
            transaction = session.getTransaction();
            transaction.begin();

            user1.setUserid(100);
            user1.setFirstname("john");
            user1.setLastname("white");

            session.update(user1);
            transaction.commit();
            System.out.println("User with ID "+user1.getUserid());

        }catch (Exception e){
            transaction.rollback();
            System.out.println(e.getMessage());
        }finally {
            session.close();
            sessionFactory.close();
        }

    }
}
