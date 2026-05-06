package org.example.demoapp.controller.product;

import org.example.demoapp.dto.response.product.ProductResponse;
import org.example.demoapp.model.product.Product;
import org.example.demoapp.service.product.ProductFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductGetController {

    private final ProductFinderService productFinderService;

    public ProductGetController(ProductFinderService productFinderService) {
        this.productFinderService = productFinderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> find(@PathVariable Long id) {
       Product product = productFinderService.find(id);

       ProductResponse response = ProductResponse.fromEntity(product);

       return ResponseEntity.ok(response);
    }
}
