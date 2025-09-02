package com.springboot.todoapp.models.dto;

public class TodoItemResponseDTO {

    private Long id;
    private String description;
    private boolean isCompleted;

    public TodoItemResponseDTO() {
    }

    public TodoItemResponseDTO(Long id, String description, boolean isCompleted) {
        this.id = id;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
