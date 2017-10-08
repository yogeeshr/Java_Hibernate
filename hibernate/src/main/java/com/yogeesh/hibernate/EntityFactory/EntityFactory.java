package com.yogeesh.hibernate.EntityFactory;

import com.yogeesh.hibernate.entities.RiverCountryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by yogeesh.srkvs@gmail.com on 9/18/17.
 */
public class EntityFactory {

    // Create an EntityManagerFactory when you start the application.
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("Rivers");

    /**
     * Create entity manager
     * @return manager
     */
    public static EntityManager createEntityManager() {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        return manager;
    }

    public static void closeEntityManager() {
        // NEVER FORGET TO CLOSE THE ENTITY_MANAGER_FACTORY
        ENTITY_MANAGER_FACTORY.close();
    }

    /**
     * Generic method : Ingests data
     * @param object
     * @return
     */
    public static synchronized boolean create(Object object) {

        boolean didCommit = true;

        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Save the object
            manager.persist(object);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {

            didCommit=false;

            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }

            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }

        return didCommit;
    }

    /**
     *
     * @param countryCode
     * @return
     */
    public static synchronized Boolean getAndDeleteCountry(String countryCode) {

        boolean isDeleted = true;

        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;
        RiverCountryEntity country = null;

        try {

            transaction = manager.getTransaction();
            transaction.begin();

            country = manager.createQuery("SELECT s FROM RiverCountryEntity s where countryCode='"+countryCode.toUpperCase()+"'",
                    RiverCountryEntity.class).getSingleResult();

            manager.remove(country);

            // Commit the transaction
            transaction.commit();

        } catch (Exception ex) {
            isDeleted=false;

            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }

        return isDeleted;

    }

    /**
     * Delete the existing Country.
     *
     */
    public static synchronized boolean delete(Object object) {

        boolean isDeleted = true;

        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {

            // Get a transaction
            transaction = manager.getTransaction();

            // Begin the transaction
            transaction.begin();

            manager.remove(manager.contains(object) ? object : manager.merge(object));

            // Delete the student
            manager.remove(object);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {

            isDeleted = false;

            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }

        return isDeleted;
    }


}
