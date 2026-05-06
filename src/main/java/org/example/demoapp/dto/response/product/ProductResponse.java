package org.example.demoapp.dto.response.product;

import org.example.demoapp.model.product.Product;

public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean active;
    private Long stock;

    public ProductResponse() {}

    public ProductResponse(
        Long id,
        String name, 
        String description, 
        Double price, 
        Boolean active, 
        Long stock
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.stock = stock;
    }

    static public ProductResponse fromEntity(Product product) {
        return new ProductResponse(
            request.getId(),
            request.getName(),
            request.getDescription(),
            request.getPrice(),
            request.getActive(),
            request.getStock()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getActive() {
        return active;
    }

    public String getStock() {
        return stock;
    }
}
