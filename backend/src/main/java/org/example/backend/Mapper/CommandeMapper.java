package org.example.backend.Mapper;

import org.example.backend.Dto.CommandeDetailsResponse;
import org.example.backend.Dto.CommandeRequest;
import org.example.backend.Dto.CommandeResponse;
import org.example.backend.Dto.ProduitResponse;
import org.example.backend.Entity.Client;
import org.example.backend.Entity.Commande;
import org.example.backend.Entity.Produit;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CommandeMapper {

    public Commande toEntity(CommandeRequest commandeRequest, Client client, List<Produit> produits ) {
        Commande commande = new Commande();
        commande.setClient(client);
        commande.setProduits(produits);
        return commande;
    }

    public CommandeResponse toResponse(Commande commande){
        CommandeResponse commandeResponse = new CommandeResponse();
        commandeResponse.setTrackingId(commande.getTrackingId());
        commandeResponse.setDate(commande.getDate());
        if (commande.getClient() != null) {
            commandeResponse.setClient(
                    commande.getClient().getNom() + " " + commande.getClient().getPrenom());
        }

        if (commande.getProduits() != null) {
            List<CommandeDetailsResponse> produits = commande.getProduits()
                    .stream()
                    .map(p -> new CommandeDetailsResponse( p.getNom(), p.getPrixUnitaire()))
                    .collect(Collectors.toList());
            commandeResponse.setProduits(produits);

            double total = produits.stream()
                    .mapToDouble(CommandeDetailsResponse::getPrixUnitaire)
                    .sum();
            commandeResponse.setPrixTotal(total);
        } else {
            commandeResponse.setProduits(List.of());
            commandeResponse.setPrixTotal(0.0);
        }

        return commandeResponse;
    }


}

