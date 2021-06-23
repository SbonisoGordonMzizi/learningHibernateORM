package co.za.gordonmzizi;

import co.za.gordonmzizi.persistance.Phone;
import co.za.gordonmzizi.persistance.Human;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
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

                      Phone phone1 = new Phone();
                      phone1.setBrandName("Nokia");
                      Phone phone2 = new Phone();
                      phone2.setBrandName("Apple");
                      Human human1 = new Human();
                      human1.setFirstName("Vice");

                      human1.getPhones().add(phone1);
                      human1.getPhones().add(phone2);
                      phone1.setHuman(human1);
                      phone2.setHuman(human1);



                      transaction.begin();
                      session.save(human1);
                      session.save(phone1);
                      session.save(phone2);
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
