package org.example.demoapp.service.product;

import org.example.demoapp.dto.request.product.ProductRequest;
import org.example.demoapp.model.product.Product;
import org.example.demoapp.repository.product.JpaProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductUpdaterService {
    private final JpaProductRepository jpaProductRepository;
    private final ProductFinderService productFinderService;

    public ProductUpdaterService(
            JpaProductRepository jpaProductRepository,
            ProductFinderService productFinderService
    ) {
        this.jpaProductRepository = jpaProductRepository;
        this.productFinderService = productFinderService;
    }

    public Product update(ProductRequest productRequest, Long id) {
        Product product = productFinderService.find(id);

        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());

        return jpaProductRepository.save(product);
    }
}
