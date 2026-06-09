package org.example.demoapp.service.movement;

import org.example.demoapp.dto.request.movement.MovementRequest;
import org.example.demoapp.model.category.Category;
import org.example.demoapp.model.movement.Movement;
import org.example.demoapp.repository.movement.JpaMovementRepository;
import org.example.demoapp.service.category.CategoryFinderService;
import org.springframework.stereotype.Service;

@Service
public class MovementCreatorService {
    private final JpaMovementRepository jpaMovementRepository;
    private final CategoryFinderService categoryFinderService;

    public MovementCreatorService(
            JpaMovementRepository jpaMovementRepository,
            CategoryFinderService categoryFinderService
    ) {
        this.jpaMovementRepository = jpaMovementRepository;
        this.categoryFinderService = categoryFinderService;
    }

    public Movement create(MovementRequest request) {
        Movement movement = Movement.fromRequest(request);

        Category category = categoryFinderService.find(request.getCategoryId());

        movement.setCategory(category);

        return jpaMovementRepository.save(movement);
    }
}
