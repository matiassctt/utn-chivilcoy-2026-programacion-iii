package org.example.demoapp.dto.response.movement;

import org.example.demoapp.model.movement.Movement;

public class MovementResponse {
    private Long id;
    private String name;
    private String description;

    public MovementResponse() {}

    public MovementResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    static public MovementResponse fromEntity(Movement movement) {
        return new MovementResponse(
                movement.getId(),
                movement.getName(),
                movement.getDescription()
        );
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
