package org.example.demoapp.service.category;

import org.example.demoapp.exception.category.CategoryNotFoundException;
import org.example.demoapp.model.category.Category;
import org.example.demoapp.repository.category.JpaCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryFinderService {

    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryFinderService(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    public Category find(Long id) {
        return jpaCategoryRepository.findById(id)
                .orElseThrow( () -> new CategoryNotFoundException(id));
    }
}
