package com.example.examen.aplication;

import com.example.examen.domain.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {


    public Flux<Product> getAllProducts();

    public Mono<Product> getProductById(Long id);

    public Mono<Product> createProduct(Product product);

    public Mono<Product> updateProduct(Long id, Product product);

    public Mono<Void> deleteProduct(Long id);

}
