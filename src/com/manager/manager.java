package com.manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class manager {

    private static EntityManagerFactory factory;
    private static EntityManager        entitymanager;

    public static EntityManager getEntityManager( String persistUnit )
    {
        if ( entitymanager == null )
        {
            factory = Persistence.createEntityManagerFactory( persistUnit );

            entitymanager = factory.createEntityManager();
        }
        return entitymanager;
    }

}
