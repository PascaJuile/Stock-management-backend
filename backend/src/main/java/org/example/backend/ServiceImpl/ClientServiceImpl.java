package org.example.backend.ServiceImpl;

import jakarta.transaction.Transactional;
import org.example.backend.AuthConfigs.JwtUtil;
import org.example.backend.Dto.ClientRequest;
import org.example.backend.Dto.ClientResponse;
import org.example.backend.Entity.Client;
import org.example.backend.Mapper.ClientMapper;
import org.example.backend.Repository.ClientRepository;
import org.example.backend.Service.ClientService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        Client client = clientMapper.toEntity(clientRequest);
        // Génération du token
        String jwt = JwtUtil.generateToken(client.getTrackingId().toString());
        client.setToken(jwt);
        Client savedClient = clientRepository.save(client);
        return clientMapper.toResponse(savedClient);
    }
}
