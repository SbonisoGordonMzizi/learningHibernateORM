package co.za.gordonmzizi;

import co.za.gordonmzizi.persistancelayer.Users;
import org.hibernate.cfg.Configuration;
import  org.hibernate.SessionFactory;
import org.hibernate.Session;

public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = null;
        SessionFactory sessionFactory = null;
        Session session = null;

        try{
            configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();

            Users user1 = (Users) session.get(Users.class,101);
            if(user1 == null){
                 System.out.println("User not found");
            }else {
                System.out.println("____________ OUTPUT __________");
                System.out.println("UserID \t\t\t: " + user1.getUserid());
                System.out.println("User FirstName \t: " + user1.getFirstname());
                System.out.println("User LastName \t: " + user1.getLastname());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
