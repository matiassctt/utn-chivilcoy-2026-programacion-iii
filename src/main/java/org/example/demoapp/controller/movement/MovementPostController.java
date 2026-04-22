package org.example.demoapp.controller.movement;

import org.example.demoapp.dto.request.movement.MovementRequest;
import org.example.demoapp.dto.response.movement.MovementResponse;
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
    public ResponseEntity<MovementResponse> create(@RequestBody MovementRequest movementRequest) {
        Movement movement =  movementCreatorService.create(movementRequest);

        MovementResponse movementResponse = MovementResponse.fromEntity(movement);

        return ResponseEntity.status(HttpStatus.CREATED).body(movementResponse);
    }
}
