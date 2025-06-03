package org.example.backend.ServiceImpl;

import jakarta.transaction.Transactional;
import org.example.backend.Dto.ClientRequest;
import org.example.backend.Dto.ClientResponse;
import org.example.backend.Entity.Client;
import org.example.backend.Mapper.ClientMapper;
import org.example.backend.Repository.ClientRepository;
import org.example.backend.Service.ClientService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientServceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        Client client = clientMapper.toEntity(clientRequest);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toResponse(savedClient);
    }
}
