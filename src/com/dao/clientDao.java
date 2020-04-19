package com.dao;

import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.beans.client;
import com.manager.manager;

public class clientDao {

    public static final HashSet<String> liste_prd     = new HashSet<String>();
    private EntityManager               entityManager = manager.getEntityManager( "RealEstate" );

    // Méthode ajouter l'entité à la bd
    public void ajouter( client c )
    {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist( c );
        tx.commit();
    }

    // Métthode modifier l'entité client
    public void modifier( client c )
    {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge( c );
        tx.commit();
    }

    // Méthode Supprimer l'entité client
    public void supprimer( client c )
    {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        c = entityManager.merge( c ); // Important
        entityManager.remove( c );
        tx.commit();

    }

    // Méthode Consulter l'entité client
    public client consulter( client c, Object id )
    {
        return entityManager.find( c.getClass(), id );
    }

    // Méthode pour lister tous les objets à partir de la bd
    public List<client> get_liste_produits()
    {
        List<client> ls_clt = entityManager.createQuery( "select c from client c" ).getResultList();
        return ls_clt;
    }

    // Récupérer Id du clt à partir de son pseudo
    public int getIdClt( String pseudo, String password )
    {
        try
        {
            Query rq = entityManager.createQuery( "select c.id from client c where c.pseudo =:ps and c.pass=:pw" );
            rq.setParameter( "ps", pseudo );
            rq.setParameter( "pw", password );

            return (int) rq.getSingleResult();
        } catch ( NoResultException e )
        {
            return 0;
        }
    }
}
