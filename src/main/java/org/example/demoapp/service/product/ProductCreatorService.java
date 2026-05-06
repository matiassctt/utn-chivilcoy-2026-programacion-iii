package org.example.demoapp.service.product;

import org.example.demoapp.dto.request.product.ProductRequest;
import org.example.demoapp.model.product.Product;
import org.example.demoapp.repository.product.JpaProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCreatorService {
    private final JpaProductRepository jpaProductRepository;

    public ProductCreatorService(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    public Product create(ProductRequest request) {
        Product product = Product.fromRequest(request);
        return jpaProductRepository.save(product);
    }
}
