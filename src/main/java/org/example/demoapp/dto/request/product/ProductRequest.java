package org.example.demoapp.dto.request.product;

public class ProductRequest {
    private String name;
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
