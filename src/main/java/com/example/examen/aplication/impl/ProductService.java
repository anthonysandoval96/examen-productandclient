package com.example.examen.aplication.impl;

import com.example.examen.aplication.IProductService;
import com.example.examen.domain.entity.Product;
import com.example.examen.infraestructure.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor

public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    @Override
    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> updateProduct(Long id, Product product) {
        return productRepository.findById(id)
                .flatMap(existingProduct -> {
                    existingProduct.setNombre(product.getNombre());
                    existingProduct.setPrecio(product.getPrecio());
                    return productRepository.save(existingProduct);
                });
    }

    @Override
    public Mono<Void> deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }
}
