package org.example.demoapp.controller.category;

import org.example.demoapp.dto.response.category.CategoryResponse;
import org.example.demoapp.model.category.Category;
import org.example.demoapp.service.category.CategoryFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
public class CategoryGetController {

    private final CategoryFinderService categoryFinderService;

    public CategoryGetController(CategoryFinderService categoryFinderService) {
        this.categoryFinderService = categoryFinderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> find(@PathVariable Long id) {
       Category category = categoryFinderService.find(id);

       CategoryResponse response = CategoryResponse.fromEntity(category);

       return ResponseEntity.ok(response);
    }
}
