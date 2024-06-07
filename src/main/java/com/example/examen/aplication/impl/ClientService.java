package com.example.examen.aplication.impl;

import com.example.examen.aplication.IClientService;
import com.example.examen.domain.entity.Client;
import com.example.examen.infraestructure.repository.IClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {

    private final IClientRepository clientRepository;

    @Override
    public Flux<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Mono<Client> createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Client> updateClient(Long id, Client client) {
        return clientRepository.findById(id)
                .flatMap(existingclient -> {
                    existingclient.setNombre(client.getNombre());
                    return clientRepository.save(existingclient);
                });
    }

    @Override
    public Mono<Void> deleteClient(Long id) {
        return clientRepository.deleteById(id);
    }
}
