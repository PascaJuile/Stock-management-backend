package org.example.backend.Service;

import org.example.backend.Dto.ClientRequest;
import org.example.backend.Dto.ClientResponse;

public interface ClientService {

    //créer un client
    ClientResponse createClient(ClientRequest clientRequest);
}
