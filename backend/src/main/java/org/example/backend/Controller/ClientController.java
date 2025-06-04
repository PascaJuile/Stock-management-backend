package org.example.backend.Controller;

import org.example.backend.Dto.ClientRequest;
import org.example.backend.Dto.ClientResponse;
import org.example.backend.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clients")
@CrossOrigin("*")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create-client")
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest clientRequest){
        ClientResponse clientResponse = clientService.createClient(clientRequest);
        return ResponseEntity.ok(clientResponse);
    }
}
