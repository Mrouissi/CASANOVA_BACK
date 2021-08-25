package com.istic.casanova.model;

import javax.persistence.*;

@Entity
public class Prix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double prixMetreHT;

    private Double prixForfait;

    private Double PrixUnitaire;

    private Double prixMlHT;

    @ManyToOne
    private PrestationARealiser prestationARealiser;

    @ManyToOne
    private ElementARenover elementARenover;

    @ManyToOne
    private TypesTravaux typesTravaux;

    @ManyToOne
    private SupportExistant supportExistant;

    @ManyToOne
    private MateriauxMiseEnPlace materiauxMiseEnPlace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrixMetreHT() {
        return prixMetreHT;
    }

    public void setPrixMetreHT(Double prixMetreHT) {
        this.prixMetreHT = prixMetreHT;
    }


    public PrestationARealiser getPrestationARealiser() {
        return prestationARealiser;
    }

    public void setPrestationARealiser(PrestationARealiser prestationARealiser) {
        this.prestationARealiser = prestationARealiser;
    }

    public ElementARenover getElementARenover() {
        return elementARenover;
    }

    public void setElementARenover(ElementARenover elementARenover) {
        this.elementARenover = elementARenover;
    }

    public TypesTravaux getTypesTravaux() {
        return typesTravaux;
    }

    public void setTypesTravaux(TypesTravaux typesTravaux) {
        this.typesTravaux = typesTravaux;
    }

    public SupportExistant getSupportExistant() {
        return supportExistant;
    }

    public void setSupportExistant(SupportExistant supportExistant) {
        this.supportExistant = supportExistant;
    }

    public Double getPrixForfait() {
        return prixForfait;
    }

    public void setPrixForfait(Double prixForfait) {
        this.prixForfait = prixForfait;
    }

    public Double getPrixUnitaire() {
        return PrixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        PrixUnitaire = prixUnitaire;
    }

    public Double getPrixMlHT() {
        return prixMlHT;
    }

    public void setPrixMlHT(Double prixMlHT) {
        this.prixMlHT = prixMlHT;
    }

    public MateriauxMiseEnPlace getMateriauxMiseEnPlace() {
        return materiauxMiseEnPlace;
    }

    public void setMateriauxMiseEnPlace(MateriauxMiseEnPlace materiauxMiseEnPlace) {
        this.materiauxMiseEnPlace = materiauxMiseEnPlace;
    }
}
