package co.za.gordonmzizi;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import co.za.gordonmzizi.persistencelayer.Users;
import javax.persistence.Persistence;

public class App 
{
    public static void main( String[] args ) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("UserSystem5");
            entityManager = entityManagerFactory.createEntityManager();

            Users user1 = new Users();
            user1.setFirstname("Bob");
            user1.setLastname("Smith");

            Users user2 = new Users();
            user2.setFirstname("Jerry");
            user2.setLastname("White");

            Users user3 = new Users();
            user3.setFirstname("tom");
            user3.setLastname("lorry");

            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user1);
            entityManager.persist(user2);
            entityManager.persist(user3);
            transaction.commit();
            System.out.println("Transaction completed");
        }catch (Exception e){
            transaction.rollback();
            System.out.println("Error Occured  :  "+e.getMessage());
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
