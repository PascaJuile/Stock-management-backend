package org.example.backend.Service;

import org.example.backend.Dto.CommandeRequest;
import org.example.backend.Dto.CommandeResponse;

public interface CommandeService {

    //créer une commande
    CommandeResponse addCommande(CommandeRequest commandeRequest);
}
