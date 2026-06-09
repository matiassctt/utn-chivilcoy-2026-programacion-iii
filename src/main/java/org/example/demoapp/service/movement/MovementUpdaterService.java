package org.example.demoapp.service.movement;

import org.example.demoapp.dto.request.movement.MovementRequest;
import org.example.demoapp.model.category.Category;
import org.example.demoapp.model.movement.Movement;
import org.example.demoapp.repository.movement.JpaMovementRepository;
import org.example.demoapp.service.category.CategoryFinderService;
import org.springframework.stereotype.Service;

@Service
public class MovementUpdaterService {
    private final JpaMovementRepository jpaMovementRepository;
    private final MovementFinderService movementFinderService;
    private final CategoryFinderService categoryFinderService;

    public MovementUpdaterService(
            JpaMovementRepository jpaMovementRepository,
            MovementFinderService movementFinderService,
            CategoryFinderService categoryFinderService
    ) {
        this.jpaMovementRepository = jpaMovementRepository;
        this.movementFinderService = movementFinderService;
        this.categoryFinderService = categoryFinderService;
    }

    public Movement update(MovementRequest movementRequest, Long id) {
        Movement movement = movementFinderService.find(id);

        Category category = categoryFinderService.find(movementRequest.getCategoryId());

        movement.setName(movementRequest.getName());
        movement.setDescription(movementRequest.getDescription());
        movement.setCategory(category);

        return jpaMovementRepository.save(movement);
    }
}
