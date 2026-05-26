package org.example.demoapp.repository.category;

import org.example.demoapp.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaCategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
}
