package org.example.demoapp.service.product;

import org.example.demoapp.model.product.Product;
import org.example.demoapp.repository.product.JpaProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductsSearcherService {
    private final JpaProductRepository jpaProductRepository;

    public ProductsSearcherService(
            JpaProductRepository jpaProductRepository
    ) {
        this.jpaProductRepository = jpaProductRepository;
    }

    public Page<Product> findAll(Pageable pageable) {
        return jpaProductRepository.findAll(pageable);
    }
}
