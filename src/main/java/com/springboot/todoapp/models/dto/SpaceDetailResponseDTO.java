package com.springboot.todoapp.models.dto;

import java.util.HashSet;
import java.util.Set;

public class SpaceDetailResponseDTO {

    private Long id;
    private String spaceName;
    private Set<TodoItemResponseDTO> todoItems;

    public SpaceDetailResponseDTO() {
    }

    public SpaceDetailResponseDTO(Long id, String spaceName, Set<TodoItemResponseDTO> todoItems) {
        this.id = id;
        this.spaceName = spaceName;
        this.todoItems = todoItems;
    }

    public SpaceDetailResponseDTO(Long id, String spaceName) {
        this.id = id;
        this.spaceName = spaceName;
        this.todoItems = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public Set<TodoItemResponseDTO> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(Set<TodoItemResponseDTO> todoItems) {
        this.todoItems = todoItems;
    }
}
