package org.example.demoapp.controller.product;

import jakarta.validation.Valid;
import org.example.demoapp.dto.request.product.ProductRequest;
import org.example.demoapp.dto.response.product.ProductResponse;
import org.example.demoapp.model.product.Product;
import org.example.demoapp.service.product.ProductUpdaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
public class ProductPutController {
    private final ProductUpdaterService productUpdaterService;

    public ProductPutController(
            ProductUpdaterService productUpdaterService
    ) {
        this.productUpdaterService = productUpdaterService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request
    ) {
        Product product = productUpdaterService.update(request, id);

        ProductResponse response = ProductResponse.fromEntity(product);

        return ResponseEntity.ok(response);
    }
}
