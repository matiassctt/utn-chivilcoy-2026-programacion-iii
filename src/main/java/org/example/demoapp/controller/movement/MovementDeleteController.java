package org.example.demoapp.controller.movement;

import org.example.demoapp.service.movement.MovementDeleterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movements")
public class MovementDeleteController {
    private final MovementDeleterService movementDeleterService;

    public MovementDeleteController(MovementDeleterService movementDeleterService) {
        this.movementDeleterService = movementDeleterService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movementDeleterService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
