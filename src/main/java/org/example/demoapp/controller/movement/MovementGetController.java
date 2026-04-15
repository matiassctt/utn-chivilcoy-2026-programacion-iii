package org.example.demoapp.controller.movement;

import org.example.demoapp.dto.response.movement.MovementResponse;
import org.example.demoapp.model.movement.Movement;
import org.example.demoapp.service.movement.MovementFinderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movements")
public class MovementGetController {

    private final MovementFinderService movementFinderService;

    public MovementGetController(MovementFinderService movementFinderService) {
        this.movementFinderService = movementFinderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovementResponse> find(@PathVariable Long id) {
       Movement movement = movementFinderService.find(id);

        MovementResponse movementResponse = new MovementResponse(
                movement.getId(),
                movement.getName(),
                movement.getDescription()
        );

       return ResponseEntity.ok(movementResponse);
    }
}
