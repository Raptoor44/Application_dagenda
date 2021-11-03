package com.example.myapplication.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Taches implements Serializable {

    private String nom = "nom inconnu";
    private String text = "Description incconu";
    private Date date;
    private boolean valide;
    private static int universal_id = 0;
    private int id;


    public Taches(String text, Date date, String nom) {
        this.text = text;
        this.date = date;
        this.valide = false;
        this.nom = nom;
        this.id = universal_id;
        universal_id++;

    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }


    @Override
    public String toString() {
        SimpleDateFormat formater = null;
        formater = new SimpleDateFormat("dd/MM/yyyy");


        return
                String.format("nom='" + nom + '\'' +
                        ", text='" + text + '\'' +
                        ", date=" + formater.format(date))
                ;
    }


}
