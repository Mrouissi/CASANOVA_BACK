package com.istic.casanova.gestion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Points {

    @Id
    @GeneratedValue
    @Column(name = "id_points")
    private Long idPoints;

    @Column(name = "jour")
    private String jour;

    @Column(name = "date")
    private String date;

    @Column(name = "clients")
    private String client;

    @Column(name = "type_travaux")
    private String typeTravaux;

    @Column(name = "poseur")
    private String poseur;

    @Column(name = "points_total")
    private String pointsTotal;

    @Column(name = "num_intervention")
    private String unmIntervention;

    @Column(name = "a_facturer")
    private String aFacturer;

    @Column(name = "nbre_camions")
    private String nbCamion;

    @Column(name = "points")
    private String point;

    @Column(name = "points_poseur")
    private String pointsPoseur;

    public Long getIdPoints() {
        return idPoints;
    }

    public void setIdPoints(Long idPoints) {
        this.idPoints = idPoints;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getTypeTravaux() {
        return typeTravaux;
    }

    public void setTypeTravaux(String typeTravaux) {
        this.typeTravaux = typeTravaux;
    }

    public String getPoseur() {
        return poseur;
    }

    public void setPoseur(String poseur) {
        this.poseur = poseur;
    }

    public String getPointsTotal() {
        return pointsTotal;
    }

    public void setPointsTotal(String pointsTotal) {
        this.pointsTotal = pointsTotal;
    }

    public String getUnmIntervention() {
        return unmIntervention;
    }

    public void setUnmIntervention(String unmIntervention) {
        this.unmIntervention = unmIntervention;
    }

    public String getaFacturer() {
        return aFacturer;
    }

    public void setaFacturer(String aFacturer) {
        this.aFacturer = aFacturer;
    }

    public String getNbCamion() {
        return nbCamion;
    }

    public void setNbCamion(String nbCamion) {
        this.nbCamion = nbCamion;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPointsPoseur() {
        return pointsPoseur;
    }

    public void setPointsPoseur(String pointsPoseur) {
        this.pointsPoseur = pointsPoseur;
    }
}
