package com.example.myapplication.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.UUID;

public class List_rubriques implements Serializable {


    private LinkedList<Taches> list_taches;
    private String nom;
    private static int id = 0;
    private boolean valide = false;
    private int V_id;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LinkedList<Taches> getList_taches() {
        return list_taches;
    }

    public String getNom() {
        return nom;
    }

    public List_rubriques(String nom) {
        this.list_taches = new LinkedList<Taches>();
        this.nom = nom;
        this.V_id = this.id;
        this.id++;

    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public int getV_id() {
        return V_id;
    }

    @Override
    public String toString() {
        return
                "nom='" + nom + '\''
               ;
    }


}
