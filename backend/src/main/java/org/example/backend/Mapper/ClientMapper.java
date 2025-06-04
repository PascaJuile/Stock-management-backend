package org.example.backend.Mapper;

import org.example.backend.Dto.ClientRequest;
import org.example.backend.Dto.ClientResponse;
import org.example.backend.Entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientRequest clientRequest) {
        Client client = new Client();
        client.setNom(clientRequest.getNom());
        client.setPrenom(clientRequest.getPrenom());
        client.setAdresse(clientRequest.getAdresse());
        client.setTelephone(clientRequest.getTelephone());
        return client;
    }

    public ClientResponse toResponse(Client client) {
        ClientResponse clientResponse = new ClientResponse();
        clientResponse.setTrackingId(client.getTrackingId());
        clientResponse.setToken(client.getToken());
        clientResponse.setNom(client.getNom());
        clientResponse.setPrenom(client.getPrenom());
        clientResponse.setAdresse(client.getAdresse());
        clientResponse.setTelephone(client.getTelephone());
        return clientResponse;
    }
}
