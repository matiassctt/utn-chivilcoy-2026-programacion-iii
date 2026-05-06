package org.example.demoapp.controller.product;

import org.example.demoapp.service.product.ProductDeleterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductDeleteController {
    private final ProductDeleterService productDeleterService;

    public ProductDeleteController(ProductDeleterService productDeleterService) {
        this.productDeleterService = productDeleterService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productDeleterService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
