package com.istic.casanova.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.istic.casanova.utils.enums.EtatDossier;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JsonBackReference
    private Client client;

    @Enumerated(EnumType.STRING)
    private EtatDossier etat_dossier;

    @OneToOne
    @JsonBackReference
    private Chantier chantier;

    @Column(name = "montant_acompte")
    private String montant_acompte;

    @Column(name = "montant_total")
    private String montant_total;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_commande")
    private Date date_commande;

    @JsonManagedReference
    @ElementCollection(targetClass=FileDB.class)
    private List<FileDB> files;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public EtatDossier getEtat_dossier() { return etat_dossier; }
    public void setEtat_dossier(EtatDossier etat_dossier) { this.etat_dossier = etat_dossier; }

    public EtatDossier getEtat_chaniter() { return etat_chaniter; }
    public void setEtat_chaniter(EtatDossier etat_chaniter) { this.etat_chaniter = etat_chaniter; }

    public Chantier getChantier() { return chantier; }
    public void setChantier(Chantier chantier) { this.chantier = chantier; }

    public String getMontant_acompte() { return montant_acompte; }
    public void setMontant_acompte(String montant_acompte) { this.montant_acompte = montant_acompte; }

    public String getMontant_total() { return montant_total; }
    public void setMontant_total(String montant_total) { this.montant_total = montant_total; }

    public Date getDate_commande() { return date_commande; }
    public void setDate_commande(Date date_commande) { this.date_commande = date_commande; }

    @OneToMany(mappedBy = "dossier")
    public List<FileDB> getFiles() { return files; }

    public void setFiles(List<FileDB> files) { this.files = files; }
    public void addFile(FileDB fileDB) { this.files.add(fileDB); }
}
