package org.example.demoapp.service.category;

import org.example.demoapp.dto.request.category.CategoryRequest;
import org.example.demoapp.model.category.Category;
import org.example.demoapp.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryCreatorService {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryCreatorService(
        JpaCategoryRepository jpaCategoryRepository
    ) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    public Category create(CategoryRequest request) {
        Category category = Category.fromRequest(request);
        return jpaCategoryRepository.save(category);
    }
}
