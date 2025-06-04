package org.example.backend.ServiceImpl;

import jakarta.transaction.Transactional;
import org.example.backend.Dto.CommandeRequest;
import org.example.backend.Dto.CommandeResponse;
import org.example.backend.Dto.ProduitResponse;
import org.example.backend.Entity.Client;
import org.example.backend.Entity.Commande;
import org.example.backend.Entity.Produit;
import org.example.backend.Mapper.CommandeMapper;
import org.example.backend.Repository.ClientRepository;
import org.example.backend.Repository.CommandeRepository;
import org.example.backend.Repository.ProduitRepository;
import org.example.backend.Service.CommandeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;
    private final CommandeMapper commandeMapper;
    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository, CommandeMapper commandeMapper, ClientRepository clientRepository, ProduitRepository produitRepository) {
        this.commandeRepository = commandeRepository;
        this.commandeMapper = commandeMapper;
        this.clientRepository = clientRepository;
        this.produitRepository = produitRepository;
    }

    @Override
    public CommandeResponse addCommande(CommandeRequest commandeRequest) {
        // Recherche du client
        Client client = clientRepository.findByTrackingId(commandeRequest.getClientTrackingId())
                .orElseThrow(() -> new RuntimeException(
                        "Client avec le trackingId " + commandeRequest.getClientTrackingId() + " est introuvable"
                ));

        // Récupération des produits
        List<Produit> produits = commandeRequest.getProduitIds().stream()
                .map(trackingId -> produitRepository.findByTrackingId(trackingId)
                        .orElseThrow(() -> new RuntimeException("Produit avec trackingId " + trackingId + " introuvable")))
                .collect(Collectors.toList());

        // Conversion en entité
        Commande commande = commandeMapper.toEntity(commandeRequest, client, produits);

        // Calcul du total
        double total = produits.stream()
                .mapToDouble(Produit::getPrixUnitaire)
                .sum();
        commande.setPrixTotal(total);

        // Enregistrement
        Commande saved = commandeRepository.save(commande);

        // Conversion en réponse
        return commandeMapper.toResponse(saved);
    }

    @Override
    public CommandeResponse searchCommande(UUID trackingId) {
        Commande commande = commandeRepository.findByTrackingId(trackingId).orElseThrow(
                () -> new RuntimeException("Commande avec le trackingId" + trackingId + " n'existe pas ")
        );
        return commandeMapper.toResponse(commande);
    }

    @Override
    public List<CommandeResponse> getAllCommande() {
        return commandeRepository.findCommandeOrderByDate().
                stream()
                .map(commandeMapper::toResponse)
                .toList();
    }

}
