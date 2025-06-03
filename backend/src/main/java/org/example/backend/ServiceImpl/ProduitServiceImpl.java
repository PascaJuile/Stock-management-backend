package org.example.backend.ServiceImpl;

import jakarta.transaction.Transactional;
import org.example.backend.Dto.ProduitRequest;
import org.example.backend.Dto.ProduitResponse;
import org.example.backend.Entity.Produit;
import org.example.backend.Mapper.ProduitMapper;
import org.example.backend.Repository.ProduitRepository;
import org.example.backend.Service.ProduitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;

    public ProduitServiceImpl(ProduitRepository produitRepository, ProduitMapper produitMapper) {
        this.produitRepository = produitRepository;
        this.produitMapper = produitMapper;
    }

    @Override
    public ProduitResponse createProduit(ProduitRequest produitRequest) {
        Produit produit = produitMapper.toEntity(produitRequest);
        Produit saved = produitRepository.save(produit);
        return produitMapper.toResponse(saved);
    }

    @Override
    public ProduitResponse updateProduit(ProduitRequest produitRequest, UUID trackingId) {
        Produit produit = produitRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("Le produit avec le trackingId" + trackingId + " n'existe pas"));
        produit.setNom(produitRequest.getNom());
        produit.setQuantite(produitRequest.getQuantite());
        produit.setDescription(produitRequest.getDescription());
        produit.setPrixUnitaire(produitRequest.getPrixUnitaire());
        Produit saved = produitRepository.save(produit);
        return produitMapper.toResponse(saved);
    }

    @Override
    public ProduitResponse getProduit(UUID trackingId) {
        Produit produit = produitRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("Le produit avec le trackingId" + trackingId + " n'existe pas"));
        return produitMapper.toResponse(produit);
    }

    @Override
    public List<ProduitResponse> getAllProduits() {
        return produitRepository.findProduitOrderByNom()
                .stream()
                .map(produitMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteProduit(UUID trackingId) {
        Produit produit = produitRepository.findByTrackingId(trackingId).orElseThrow(()-> new RuntimeException("Le produit avec le trackingId" + trackingId + " n'existe pas"));
        produitRepository.delete(produit);
    }
}
