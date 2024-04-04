package be.intecbrussel.connection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class EntityManagerProvider {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("countrydb");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
