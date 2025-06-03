package org.example.backend.Controller;

import org.example.backend.Dto.ProduitRequest;
import org.example.backend.Dto.ProduitResponse;
import org.example.backend.Entity.Produit;
import org.example.backend.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/produits")
@CrossOrigin("*")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @PostMapping("/create-produit")
    public ResponseEntity<ProduitResponse> createProduit(@RequestBody ProduitRequest produitRequest){
        ProduitResponse produitResponse = produitService.createProduit(produitRequest);
        return ResponseEntity.ok(produitResponse);
    }

    @PutMapping("update-produit/{trackingId}")
    public ResponseEntity<ProduitResponse> updateProduit(@RequestBody ProduitRequest produitRequest, @PathVariable UUID trackingId){
        ProduitResponse produitResponse = produitService.updateProduit(produitRequest, trackingId);
        return ResponseEntity.ok(produitResponse);

    }
}
