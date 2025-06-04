package org.example.backend.Service;

import org.example.backend.Dto.CommandeRequest;
import org.example.backend.Dto.CommandeResponse;

import java.util.List;
import java.util.UUID;

public interface CommandeService {

    //créer une commande
    CommandeResponse addCommande(CommandeRequest commandeRequest);

    //Rechercher une commande
    CommandeResponse searchCommande( UUID trackingId);

    //Liste des commande
    List<CommandeResponse> getAllCommande();
}
