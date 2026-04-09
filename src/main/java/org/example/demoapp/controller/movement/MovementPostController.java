package org.example.demoapp.controller.movement;

import org.example.demoapp.dto.request.movement.MovementRequest;
import org.example.demoapp.model.movement.Movement;
import org.example.demoapp.service.movement.MovementCreatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movements")
public class MovementPostController {
    private final MovementCreatorService movementCreatorService;

    public MovementPostController(MovementCreatorService movementCreatorService) {
        this.movementCreatorService = movementCreatorService;
    }

    @PostMapping
    public ResponseEntity<Movement> create(@RequestBody MovementRequest movementRequest) {
        Movement movement = new Movement();
        movement.setName(movementRequest.getName());
        movement.setDescription(movementRequest.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movementCreatorService.create(movement));
    }
}
