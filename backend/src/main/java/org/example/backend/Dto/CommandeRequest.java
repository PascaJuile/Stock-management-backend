package org.example.backend.Dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CommandeRequest {

    private UUID clientTrackingId;
    private List<UUID> produitIds;

    public CommandeRequest(){}


    public UUID getClientTrackingId() {
        return clientTrackingId;
    }

    public void setClientTrackingId(UUID clientTrackingId) {
        this.clientTrackingId = clientTrackingId;
    }

    public List<UUID> getProduitIds() {
        return produitIds;
    }

    public void setProduitIds(List<UUID> produitIds) {
        this.produitIds = produitIds;
    }
}
