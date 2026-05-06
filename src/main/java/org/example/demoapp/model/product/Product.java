package org.example.demoapp.model.product;

import jakarta.persistence.*;
import org.example.demoapp.dto.request.product.ProductRequest;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private Long stock;

    public Product() {}

    public Product(
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

    static public Product fromRequest(ProductRequest request) {
        return new Product(
            null,
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
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getActive() {
        return active;
    }
    public void setActive(String active) {
        this.active = active;
    }

    public String getStock() {
        return stock;
    }
    public void setStock(String stock) {
        this.stock = stock;
    }
}
