package org.example.demoapp.controller.product;

import jakarta.validation.Valid;
import org.example.demoapp.dto.request.product.ProductRequest;
import org.example.demoapp.dto.response.product.ProductResponse;
import org.example.demoapp.model.product.Product;
import org.example.demoapp.service.product.ProductCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductPostController {
    private final ProductCreatorService productCreatorService;

    public ProductPostController(ProductCreatorService productCreatorService) {
        this.productCreatorService = productCreatorService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(
            @Valid @RequestBody ProductRequest productRequest
    ) {
        Product product =  productCreatorService.create(productRequest);

        ProductResponse productResponse = ProductResponse.fromEntity(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }
}
