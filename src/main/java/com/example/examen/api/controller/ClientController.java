package com.example.examen.api.controller;

import com.example.examen.aplication.impl.ClientService;
import com.example.examen.crosscuting.utilitys.Constant;
import com.example.examen.domain.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping(Constant.API_BASE_PATH + "client")

public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public Flux<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Mono<Client> getProductById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Mono<Client> createProduct(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public Mono<Client> updateProduct(@PathVariable Long id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return clientService.deleteClient(id);
    }
}
