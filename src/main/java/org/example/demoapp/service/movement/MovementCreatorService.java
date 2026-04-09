package org.example.demoapp.service.movement;

import org.example.demoapp.model.movement.Movement;
import org.example.demoapp.repository.movement.JpaMovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementCreatorService {
    private final JpaMovementRepository jpaMovementRepository;

    public MovementCreatorService(JpaMovementRepository jpaMovementRepository) {
        this.jpaMovementRepository = jpaMovementRepository;
    }

    public Movement create(Movement movement) {
        return jpaMovementRepository.save(movement);
    }
}
