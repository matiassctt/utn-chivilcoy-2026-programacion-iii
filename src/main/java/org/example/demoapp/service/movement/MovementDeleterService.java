package org.example.demoapp.service.movement;

import org.example.demoapp.model.movement.Movement;
import org.example.demoapp.repository.movement.JpaMovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementDeleterService {
    private final JpaMovementRepository jpaMovementRepository;
    private final MovementFinderService movementFinderService;

    public MovementDeleterService(
            JpaMovementRepository jpaMovementRepository,
            MovementFinderService movementFinderService
    ) {
        this.jpaMovementRepository = jpaMovementRepository;
        this.movementFinderService = movementFinderService;
    }

    public void delete(Long id) {
        Movement movement = movementFinderService.find(id);
        jpaMovementRepository.delete(movement);
    }
}
