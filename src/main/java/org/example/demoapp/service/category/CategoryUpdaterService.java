package org.example.demoapp.service.category;

import org.example.demoapp.dto.request.category.CategoryRequest;
import org.example.demoapp.model.category.Category;
import org.example.demoapp.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryUpdaterService {
    private final JpaCategoryRepository jpaCategoryRepository;
    private final CategoryFinderService categoryFinderService;

    public CategoryUpdaterService(
            JpaCategoryRepository jpaCategoryRepository,
            CategoryFinderService categoryFinderService
    ) {
        this.jpaCategoryRepository = jpaCategoryRepository;
        this.categoryFinderService = categoryFinderService;
    }

    public Category update(CategoryRequest categoryRequest, Long id) {
        Category category = categoryFinderService.find(id);

        category.setName(categoryRequest.getName());

        return jpaCategoryRepository.save(category);
    }
}
