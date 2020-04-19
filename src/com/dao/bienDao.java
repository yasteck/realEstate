package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.beans.bien;
import com.manager.manager;

public class bienDao {

    private EntityManager entityManager = manager.getEntityManager( "RealEstate" );

    // Méthode ajouter l'entité à la bd
    public void ajouter( bien b )
    {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge( b );
        tx.commit();
    }

    // Métthode modifier l'entité client
    public void modifier( bien b )
    {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge( b );
        tx.commit();
    }

    // Méthode Supprimer l'entité client
    public void supprimer( bien b )
    {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        b = entityManager.merge( b ); // Important
        entityManager.remove( b );
        tx.commit();

    }

    // Méthode Consulter l'entité client
    public bien consulter( bien b, Object id )
    {
        return entityManager.find( b.getClass(), id );
    }

    // Méthode pour lister tous les objets à partir de la bd
    public List<bien> get_liste_bien()
    {
        List<bien> ls_clt = entityManager.createQuery( "select b from bien b order by b.date_creation desc" )
                .getResultList();
        return ls_clt;
    }

    public int get_exist_ville( String ville_nom )
    {
        try
        {
            Query rq = entityManager.createQuery( "select v.id from Ville v where v.nom = :vs" );
            rq.setParameter( "vs", ville_nom );

            return (int) rq.getSingleResult();
        } catch ( NoResultException e )
        {
            return 0;
        }

    }
}
