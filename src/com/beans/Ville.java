package com.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ville {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int        id;
    private String     nom;
    @OneToMany( targetEntity = bien.class, mappedBy = "ville", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<bien> bi;

    public Ville()
    {

    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

    public List<bien> getBi() {
        return bi;
    }

    public void setBi( List<bien> bi ) {
        this.bi = bi;
    }

}
