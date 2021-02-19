package com.istic.casanova.chantier;

import javax.persistence.*;

@Entity
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "devis_id")
    private Long id;

    @OneToOne
    private BonDeCommande bonDeCommande;

    public Devis(BonDeCommande bonDeCommande) {
        this.bonDeCommande = bonDeCommande;
    }
}
