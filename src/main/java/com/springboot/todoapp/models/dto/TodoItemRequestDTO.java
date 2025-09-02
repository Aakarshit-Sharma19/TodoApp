package com.springboot.todoapp.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TodoItemRequestDTO {

    @NotBlank(message = "Description cannot be empty")
    @Size(min = 1, max = 250, message = "Description must be between 1 and 250 characters")
    private String description;

    @NotNull(message = "Completion status cannot be null")
    private boolean isCompleted;

    public TodoItemRequestDTO() {
    }

    public TodoItemRequestDTO(String description, boolean isCompleted) {
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }

}
