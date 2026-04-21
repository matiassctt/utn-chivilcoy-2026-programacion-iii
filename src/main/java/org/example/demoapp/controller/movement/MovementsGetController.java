package org.example.demoapp.controller.movement;

import org.example.demoapp.dto.response.movement.MovementResponse;
import org.example.demoapp.model.movement.Movement;
import org.example.demoapp.service.movement.MovementsSearcherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movements")
public class MovementsGetController {
    private final MovementsSearcherService movementsSearcherService;

    public MovementsGetController(
            MovementsSearcherService movementsSearcherService
    ) {
        this.movementsSearcherService = movementsSearcherService;
    }

    @GetMapping
    //movements?page=2&size=5
    public ResponseEntity<Page<MovementResponse>> search(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Movement> movements = movementsSearcherService.findAll(pageable);

        return ResponseEntity.ok(
                movements.map(
                        movement -> MovementResponse.fromEntity(movement)
                )
        );
    }
}
