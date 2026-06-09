package org.example.demoapp.dto.request.movement;

public class MovementRequest {
    private String name;
    private String description;
    private Long categoryId;

    public MovementRequest() {}
    public MovementRequest(String name, String description, Long categoryId) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
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

    public Long getCategoryId() {return categoryId;}
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
