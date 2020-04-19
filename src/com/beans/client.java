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
public class client {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int        id;
    private String     nom;
    private String     prenom;
    private String     pseudo;
    private String     pass;
    @OneToMany( targetEntity = bien.class, mappedBy = "clt", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private List<bien> liste_bien;

    public client() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom( String prenom ) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo( String pseudo ) {
        this.pseudo = pseudo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass( String pass ) {
        this.pass = pass;
    }

    public List<bien> getListe_bien() {
        return liste_bien;
    }

    public void setListe_bien( List<bien> liste_bien ) {
        this.liste_bien = liste_bien;
    }

}
