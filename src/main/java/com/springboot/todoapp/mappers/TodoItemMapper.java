package com.springboot.todoapp.mappers;

import com.springboot.todoapp.models.dto.TodoItemRequestDTO;
import com.springboot.todoapp.models.dto.TodoItemResponseDTO;
import com.springboot.todoapp.models.entity.Space;
import com.springboot.todoapp.models.entity.TodoItem;

public class TodoItemMapper {

    public static TodoItem toEntity(TodoItemRequestDTO dto, Space space) {
        if (dto == null) {
            return null;
        }
        TodoItem todoItem = new TodoItem();
        todoItem.setDescription(dto.getDescription());
        todoItem.setCompleted(dto.getIsCompleted());
        todoItem.setSpace(space); // Associate with the provided Space entity
        return todoItem;
    }

    public static TodoItemResponseDTO toDTO(TodoItem entity) {
        if (entity == null) {
            return null;
        }
        return new TodoItemResponseDTO(entity.getId(), entity.getDescription(), entity.isCompleted());
    }
}
