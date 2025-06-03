package org.example.backend.Service;

import org.example.backend.Dto.ProduitRequest;
import org.example.backend.Dto.ProduitResponse;

import java.util.List;
import java.util.UUID;

public interface ProduitService {

    //Creation d'un produit
    ProduitResponse createProduit(ProduitRequest produitRequest);

    //Modifier un produit
    ProduitResponse updateProduit(ProduitRequest produitRequest, UUID trackingId);

    //Rechercher un produit
    ProduitResponse getProduit(UUID trackingId);

    //Récupérer une liste de produit
    List<ProduitResponse> getAllProduits();

    //Supprimer un produit
    void deleteProduit(UUID trackingId);
}
