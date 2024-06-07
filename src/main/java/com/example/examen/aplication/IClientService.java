package com.example.examen.aplication;

import com.example.examen.domain.entity.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientService {

    public Flux<Client> getAllClients();

    public Mono<Client> getClientById(Long id);

    public Mono<Client> createClient(Client client);

    public Mono<Client> updateClient(Long id, Client client);

    public Mono<Void> deleteClient(Long id);

}
