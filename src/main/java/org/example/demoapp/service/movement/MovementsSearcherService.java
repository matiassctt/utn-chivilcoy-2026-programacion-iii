package org.example.demoapp.service.movement;

import org.example.demoapp.model.movement.Movement;
import org.example.demoapp.repository.movement.JpaMovementRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovementsSearcherService {
    private final JpaMovementRepository jpaMovementRepository;

    public MovementsSearcherService(
            JpaMovementRepository jpaMovementRepository
    ) {
        this.jpaMovementRepository = jpaMovementRepository;
    }

    public Page<Movement> findAll(Pageable pageable) {
        return jpaMovementRepository.findAll(pageable);
    }
}
