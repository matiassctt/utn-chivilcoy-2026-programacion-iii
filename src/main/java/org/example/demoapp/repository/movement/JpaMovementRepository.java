package org.example.demoapp.repository.movement;

import org.example.demoapp.model.movement.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMovementRepository extends JpaRepository<Movement, Long>, JpaSpecificationExecutor<Movement> {
}
