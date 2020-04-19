package com.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public class bien {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int    id;
    private String titre;
    private String nature;
    @Column( columnDefinition = "Varchar(255) default 'disponible'" )
    // Equivalent en Annotation d'affecter une valeur par défaut
    private String etat;
    private double prix;
    private String date_creation;
    private String description;
    private double surface;
    private String adresse;
    private String img_principal;
    private String img1;
    private String img2;
    private String img3;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "ville_id" )
    private Ville  ville;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "client_id" )
    private client clt;

    public bien()
    {

    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre( String titre ) {
        this.titre = titre;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation( String date_creation ) {
        this.date_creation = date_creation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getNature() {
        return nature;
    }

    public void setNature( String nature ) {
        this.nature = nature;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat( String etat ) {
        this.etat = etat;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix( double prix ) {
        this.prix = prix;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface( double surface ) {
        this.surface = surface;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse( String adresse ) {
        this.adresse = adresse;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille( Ville ville ) {
        this.ville = ville;
    }

    public client getClt() {
        return clt;
    }

    public void setClt( client clt ) {
        this.clt = clt;
    }

    public String getImg_principal() {
        return img_principal;
    }

    public void setImg_principal( String img_principal ) {
        this.img_principal = img_principal;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1( String img1 ) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2( String img2 ) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3( String img3 ) {
        this.img3 = img3;
    }

}
