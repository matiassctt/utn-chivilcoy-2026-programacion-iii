package org.example.demoapp.service.product;

import org.example.demoapp.model.product.Product;
import org.example.demoapp.repository.product.JpaProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductDeleterService {
    private final JpaProductRepository jpaProductRepository;
    private final ProductFinderService productFinderService;

    public ProductDeleterService(
            JpaProductRepository jpaProductRepository,
            ProductFinderService productFinderService
    ) {
        this.jpaProductRepository = jpaProductRepository;
        this.productFinderService = productFinderService;
    }

    public void delete(Long id) {
        Product product = productFinderService.find(id);
        jpaProductRepository.delete(product);
    }
}
