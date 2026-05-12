package org.example.demoapp.dto.request.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductRequest {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre dene tener tantos caracteres")
    private String name;

    @NotBlank
    private String description;
    private Double price;
    private Boolean active;
    private Long stock;

    public ProductRequest() {}
    public ProductRequest(
        String name, 
        String description, 
        Double price, 
        Boolean active, 
        Long stock
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getActive() {
        return active;
    }

    public Long getStock() {
        return stock;
    }
}
