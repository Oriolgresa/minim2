package edu.upc.eetac.dsa.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by OriolGresa on 21/12/16.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Etakemon {

    String nom, descripcio,tipus;
    int id, puntuacio;

    public Etakemon() {}

    public Etakemon(String tipus, String nom, String descripcio) {
        this.tipus = tipus;
        this.nom = nom;
        this.descripcio = descripcio;
        this.puntuacio = getPuntuacioPerTipus(tipus);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public static int getPuntuacioPerTipus(String tipus) {
        tipus = tipus.toLowerCase();
        int puntuacio = 0;
        if(tipus.equals("director")) {
            puntuacio = 200;
        } else if (tipus.equals("professor")) {
            puntuacio = 100;
        } else if (tipus.equals("alumne")) {
            puntuacio = 50;
        }
        return puntuacio;
    }
}
