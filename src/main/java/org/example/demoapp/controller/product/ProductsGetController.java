package org.example.demoapp.controller.product;

import org.example.demoapp.dto.response.product.ProductResponse;
import org.example.demoapp.model.product.Product;
import org.example.demoapp.service.product.ProductsSearcherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/products")
public class ProductsGetController {
    private final ProductsSearcherService productsSearcherService;

    public ProductsGetController(
            ProductsSearcherService productsSearcherService
    ) {
        this.productsSearcherService = productsSearcherService;
    }

    @GetMapping
    //products?page=2&size=5
    public ResponseEntity<Page<ProductResponse>> search(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productsSearcherService.findAll(pageable);

        return ResponseEntity.ok(
                products.map(
                        product -> ProductResponse.fromEntity(product)
                )
        );
    }
}
