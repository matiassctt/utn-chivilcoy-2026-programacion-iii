package org.example.demoapp.dto.request.movement;

public class MovementRequest {
    private String name;
    private String description;

    public MovementRequest() {}
    public MovementRequest(String name, String description) {
        this.name = name;
        this.description = description;
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
