package com.istic.casanova.chantier;
import javax.persistence.*;
import java.util.Date;

@Entity
public class BonDeCommande {



    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bonId;


@OneToOne
    private Facturation facturation;
    private LieuEtSuivi lieuEtSuivi;
    private ModeReglement modeReglement;
    private Date dateBon;
    private Integer numBon;
    private String designation;


    @GeneratedValue
    public Long getbonId() {
        return bonId;
    }

    public LieuEtSuivi getLieuEtSuivi() {
        return lieuEtSuivi;
    }

    public void setLieuEtSuivi(LieuEtSuivi lieuEtSuivi) {
        this.lieuEtSuivi = lieuEtSuivi;
    }

    public ModeReglement getModeReglement() {
        return modeReglement;
    }

    public void setModeReglement(ModeReglement modeReglement) {
        this.modeReglement = modeReglement;
    }

}
