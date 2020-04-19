package com.beans;

import javax.persistence.Entity;

@Entity
public class Terrain extends bien {

    private String etat_terrain;

    public String getEtat_terrain() {
        return etat_terrain;
    }

    public void setEtat_terrain( String etat_terrain ) {
        this.etat_terrain = etat_terrain;
    }

}
