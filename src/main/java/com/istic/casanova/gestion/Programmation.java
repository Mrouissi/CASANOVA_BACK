package com.istic.casanova.gestion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Programmation {

    @Id
    @GeneratedValue
    @Column(name = "id_Progr")
    private Long idProgr;

    @Column(name = "immat")
    private String immat;

    @Column(name = "poseurs")
    private String poseurs;

    @Column(name = "vendeurs")
    private String vendeurs;

    @Column(name = "date_cmde")
    private String dateCmde;

    @Column(name = "adresse_chantier")
    private String adresseChantier;

    @Column(name = "types_Travaux")
    private String typesTravaux;

    @Column(name = "observation")
    private String observations;

    @Column(name = "materiaux_specifiques")
    private String materiauxSpecifs;

    @Column(name = "temps_execution")
    private String tpsExecution;

    @Column(name = "jrnee_termine")
    private String jrTermine;

    @Column(name = "pv_reception")
    private String pvRecept;

    @Column(name = "pv_SAV")
    private String pvSAV;

    @Column(name = "chq_deb_travaux")
    private String chqDeb;

    @Column(name = "chq_fin_travaux")
    private String chqFin;

    @Column(name = "suivi_conso")
    private String suiviConso;

    @Column(name = "suivi_chantier")
    private String suiviChantier;

    @Column(name = "a_facturer")
    private String aFacturer;

    @Column(name = "signature")
    private String signature;

}
