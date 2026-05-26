package org.example.demoapp.service.category;

import org.example.demoapp.model.category.Category;
import org.example.demoapp.repository.category.JpaCategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoriesSearcherService {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoriesSearcherService(
        JpaCategoryRepository jpaCategoryRepository
    ) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    public Page<Category> findAll(Pageable pageable) {
        return jpaCategoryRepository.findAll(pageable);
    }
}
