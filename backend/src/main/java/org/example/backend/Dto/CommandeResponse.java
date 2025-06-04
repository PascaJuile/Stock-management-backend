package org.example.backend.Dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CommandeResponse {

    private UUID trackingId;
    private LocalDateTime date;
    private String client;
    private List<CommandeDetailsResponse> produits;
    private double prixTotal;

    public CommandeResponse() {}

    public UUID getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(UUID trackingId) {
        this.trackingId = trackingId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<CommandeDetailsResponse> getProduits() {
        return produits;
    }

    public void setProduits(List<CommandeDetailsResponse> produits) {
        this.produits = produits;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }
}
