package co.za.gordonmzizi;

import co.za.gordonmzizi.persistance.Vehicle;
import co.za.gordonmzizi.persistance.TwoWheeler;
import co.za.gordonmzizi.persistance.FourWheeler;
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

        //Transient object state
        TwoWheeler twoWheelere = new TwoWheeler();
        twoWheelere.setVehicleName("BMW Bike");
        twoWheelere.setSteeringHandle("Bike Streering");

        FourWheeler fourWheeler = new FourWheeler();
        fourWheeler.setVehicleName("Toyata Corolar");
        fourWheeler.setSteeringWheel("Porche Streering Wheel");
        try{
            registry = new StandardServiceRegistryBuilder().configure().build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();

            //Persistence object state
            session.persist(twoWheelere);
            session.persist(fourWheeler);

            transaction.commit();
            System.out.println("Transaction Complete");
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
