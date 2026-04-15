package org.example.demoapp.exception.movement;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovementNotFoundException extends RuntimeException {

    public MovementNotFoundException(Long id) {
       super("Movement not found: Id " + id);
    }
}
