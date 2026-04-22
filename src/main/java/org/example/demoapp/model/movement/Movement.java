package org.example.demoapp.model.movement;

import jakarta.persistence.*;
import org.example.demoapp.dto.request.movement.MovementRequest;

@Entity
@Table(name="movements")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public Movement() {}

    public Movement(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    static public Movement fromRequest(MovementRequest request) {
        Movement movement = new Movement();
        movement.setName(request.getName());
        movement.setDescription(request.getDescription());
        return movement;
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
