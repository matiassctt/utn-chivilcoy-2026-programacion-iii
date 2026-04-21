package org.example.demoapp.service.movement;

import org.example.demoapp.dto.request.movement.MovementRequest;
import org.example.demoapp.model.movement.Movement;
import org.example.demoapp.repository.movement.JpaMovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementUpdaterService {
    private final JpaMovementRepository jpaMovementRepository;
    private final MovementFinderService movementFinderService;

    public MovementUpdaterService(
            JpaMovementRepository jpaMovementRepository,
            MovementFinderService movementFinderService
    ) {
        this.jpaMovementRepository = jpaMovementRepository;
        this.movementFinderService = movementFinderService;
    }

    public Movement update(MovementRequest movementRequest, Long id) {
        Movement movement = movementFinderService.find(id);

        movement.setName(movementRequest.getName());
        movement.setDescription(movementRequest.getDescription());

        return jpaMovementRepository.save(movement);
    }
}
