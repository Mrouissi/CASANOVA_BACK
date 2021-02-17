package com.istic.casanova.gestion;

import javax.persistence.*;

@Entity
public class Planning {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long idPlan;

    @Column(name = "jour")
    private String jour;

    @Column(name = "date")
    private String date;

    @Column(name = "type_travaux")
    private String typeTravaux;

    @Column(name = "vendeur")
    private String vendeur;

    @Column(name = "unite")
    private String unite;

    @Column(name = "quantite")
    private String quantite;

    @Column(name = "num_intervention")
    private Long numIntervention;

    @Column(name = "nom_client")
    private String nomClient;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "est_fini")
    private String fini;

    @Column(name = "smotif")
    private String motif;

    @Column(name = "pv")
    private String pv;

    @Column(name = "a_facturer")
    private String aFacturer;

    @Column(name = "immatriculation")
    private String immat;

    @Column(name = "chef_camion")
    private String chefCamion;

    @Column(name = "points_1")
    private String points1;

    @Column(name = "second")
    private String second;

    @Column(name = "points_2")
    private String points2;

    @Column(name = "autres")
    private String autres;

    @Column(name = "points_3")
    private String points3;

    @Column(name = "absent")
    private String absent;
}
