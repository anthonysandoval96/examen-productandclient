package com.example.examen.infraestructure.repository;

import com.example.examen.domain.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveCrudRepository<Product, Long> {

}
