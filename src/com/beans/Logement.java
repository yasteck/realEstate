package com.beans;

import javax.persistence.Entity;

@Entity
public class Logement extends bien {

    private int    nbr_pieces;
    private String etat_appart;
    private String type;

    public int getNbr_pieces() {
        return nbr_pieces;
    }

    public void setNbr_pieces( int nbr_pieces ) {
        this.nbr_pieces = nbr_pieces;
    }

    public String getEtat_appart() {
        return etat_appart;
    }

    public void setEtat_appart( String etat_appart ) {
        this.etat_appart = etat_appart;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

}
