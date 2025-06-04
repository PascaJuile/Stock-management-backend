package org.example.backend.Dto;

public class CommandeDetailsResponse {
    private String nom;
    private double prixUnitaire;

    public CommandeDetailsResponse() {}

    public CommandeDetailsResponse(String nom, double prixUnitaire) {
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
