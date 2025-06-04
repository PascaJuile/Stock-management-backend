package org.example.backend.Controller;

import org.example.backend.Dto.CommandeRequest;
import org.example.backend.Dto.CommandeResponse;
import org.example.backend.Service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/commandes")
@CrossOrigin("*")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @PostMapping("/add-commande")
    public ResponseEntity<CommandeResponse> addCommande(@RequestBody CommandeRequest commandeRequest) {
        CommandeResponse commandeResponse = commandeService.addCommande(commandeRequest);
        return ResponseEntity.ok(commandeResponse);
    }

    @GetMapping("/search-commande/{trackingId}")
    public ResponseEntity<CommandeResponse> searchCommande(@PathVariable UUID trackingId){
        CommandeResponse commandeResponse = commandeService.searchCommande(trackingId);
        return ResponseEntity.ok(commandeResponse);
    }

    @GetMapping("/liste-commandes")
    public ResponseEntity<List<CommandeResponse>> getAllCommande(){
        List<CommandeResponse> commandeResponse = commandeService.getAllCommande();
        return ResponseEntity.ok(commandeResponse);
    }
}
