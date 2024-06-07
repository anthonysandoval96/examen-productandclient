package com.example.examen.infraestructure.repository;

import com.example.examen.domain.entity.Client;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends ReactiveCrudRepository<Client, Long> {


}