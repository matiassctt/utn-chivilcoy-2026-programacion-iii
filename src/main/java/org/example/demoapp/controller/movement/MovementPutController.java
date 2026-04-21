package org.example.demoapp.controller.movement;

import org.example.demoapp.dto.request.movement.MovementRequest;
import org.example.demoapp.dto.response.movement.MovementResponse;
import org.example.demoapp.model.movement.Movement;
import org.example.demoapp.service.movement.MovementUpdaterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/movements")
public class MovementPutController {
    private final MovementUpdaterService movementUpdaterService;

    public MovementPutController(
            MovementUpdaterService movementUpdaterService
    ) {
        this.movementUpdaterService = movementUpdaterService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovementResponse> update(
            @PathVariable Long id,
            @RequestBody MovementRequest request
    ) {
        Movement movement = movementUpdaterService.update(request, id);

        MovementResponse response = MovementResponse.fromEntity(movement);

        return ResponseEntity.ok(response);
    }
}
