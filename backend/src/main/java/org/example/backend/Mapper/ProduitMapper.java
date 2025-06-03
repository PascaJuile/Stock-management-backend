package org.example.backend.Mapper;

import org.example.backend.Dto.ProduitRequest;
import org.example.backend.Dto.ProduitResponse;
import org.example.backend.Entity.Produit;
import org.springframework.stereotype.Component;

@Component
public class ProduitMapper {

    public Produit toEntity(ProduitRequest produitRequest){
        Produit produit = new Produit();
        produit.setNom(produitRequest.getNom());
        produit.setDescription(produitRequest.getDescription());
        produit.setPrixUnitaire(produitRequest.getPrixUnitaire());
        produit.setQuantite(produitRequest.getQuantite());
        return produit;
    }

    public ProduitResponse toResponse(Produit produit){
        ProduitResponse produitResponse = new ProduitResponse();
        produitResponse.setTrackingId(produit.getTrackingId());
        produitResponse.setNom(produit.getNom());
        produitResponse.setDescription(produit.getDescription());
        produitResponse.setPrixUnitaire(produit.getPrixUnitaire());
        produitResponse.setQuantite(produit.getQuantite());
        return produitResponse;
    }
}
