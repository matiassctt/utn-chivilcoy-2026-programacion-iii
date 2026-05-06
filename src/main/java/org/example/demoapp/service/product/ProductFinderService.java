package org.example.demoapp.service.product;

import org.example.demoapp.exception.product.ProductNotFoundException;
import org.example.demoapp.model.product.Product;
import org.example.demoapp.repository.product.JpaProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductFinderService {

    private final JpaProductRepository jpaProductRepository;

    public ProductFinderService(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    public Product find(Long id) {
        return jpaProductRepository.findById(id)
                .orElseThrow( () -> new ProductNotFoundException(id));
    }
}
