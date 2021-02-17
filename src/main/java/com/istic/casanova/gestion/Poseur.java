package com.istic.casanova.gestion;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Poseur {

    @Id
    @GeneratedValue
    @Column(name ="id_poseur")
    private Long idPoseur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "points_total")
    private double pointsTotal = 0;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(double pointsTotal) {
        this.pointsTotal = pointsTotal;
    }







}
