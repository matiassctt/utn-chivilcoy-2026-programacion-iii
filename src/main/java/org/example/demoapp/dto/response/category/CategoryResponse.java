package org.example.demoapp.dto.response.category;

import org.example.demoapp.model.category.Category;

public class CategoryResponse {
    private Long id;
    private String name;

    public CategoryResponse() {}

    public CategoryResponse(
        Long id,
        String name 
    ) {
        this.id = id;
        this.name = name;
    }

    static public CategoryResponse fromEntity(Category category) {
        return new CategoryResponse(
            category.getId(), 
            category.getName()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
