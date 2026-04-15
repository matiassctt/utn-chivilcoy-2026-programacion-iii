package org.example.demoapp.service.movement;

import org.example.demoapp.exception.movement.MovementNotFoundException;
import org.example.demoapp.model.movement.Movement;
import org.example.demoapp.repository.movement.JpaMovementRepository;
import org.springframework.stereotype.Service;

@Service
public class MovementFinderService {

    private final JpaMovementRepository jpaMovementRepository;

    public MovementFinderService(JpaMovementRepository jpaMovementRepository) {
        this.jpaMovementRepository = jpaMovementRepository;
    }

    public Movement find(Long id) {
        return jpaMovementRepository.findById(id)
                .orElseThrow( () -> new MovementNotFoundException(id));
    }
}
