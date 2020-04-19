package com.execute;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class envoieImageTerrain extends ActionForm {

    private static String src;
    private FormFile      yassine_file;
    private FormFile      img1;
    private FormFile      img2;
    private FormFile      img3;
    private String        titre;
    private String        nature;
    private String        etat;
    private double        prix;
    private String        date_creation;
    private String        description;
    private double        surface;
    private String        adresse;
    private String        ville;
    private String        etat_terrain;

    public static String getSrc() {
        return src;
    }

    public static void setSrc( String src ) {
        envoieImageTerrain.src = src;
    }

    public FormFile getYassine_file() {
        return yassine_file;
    }

    public void setYassine_file( FormFile yassine_file ) {
        this.yassine_file = yassine_file;
    }

    public FormFile getImg1() {
        return img1;
    }

    public void setImg1( FormFile img1 ) {
        this.img1 = img1;
    }

    public FormFile getImg2() {
        return img2;
    }

    public void setImg2( FormFile img2 ) {
        this.img2 = img2;
    }

    public FormFile getImg3() {
        return img3;
    }

    public void setImg3( FormFile img3 ) {
        this.img3 = img3;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre( String titre ) {
        this.titre = titre;
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

    public String getVille() {
        return ville;
    }

    public void setVille( String ville ) {
        this.ville = ville;
    }

    public String getEtat_terrain() {
        return etat_terrain;
    }

    public void setEtat_terrain( String etat_terrain ) {
        this.etat_terrain = etat_terrain;
    }

}
