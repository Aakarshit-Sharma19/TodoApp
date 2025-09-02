package com.springboot.todoapp.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class SpaceRequestDTO {

    @NotBlank(message = "Space name cannot be empty")
    @Size(min = 1, max = 100, message = "Space name must be between 1 and 100 characters")
    private String spaceName;

    public SpaceRequestDTO() {
    }

    public SpaceRequestDTO(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }
}
