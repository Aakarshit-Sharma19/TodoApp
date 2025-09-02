package com.springboot.todoapp.service;

import com.springboot.todoapp.mappers.SpaceMapper;
import com.springboot.todoapp.mappers.TodoItemMapper;
import com.springboot.todoapp.models.dto.SpaceRequestDTO;
import com.springboot.todoapp.models.dto.SpaceSummaryResponseDTO;
import com.springboot.todoapp.models.dto.TodoItemRequestDTO;
import com.springboot.todoapp.models.dto.TodoItemResponseDTO;
import com.springboot.todoapp.models.entity.Space;
import com.springboot.todoapp.models.entity.TodoItem;
import com.springboot.todoapp.repositories.SpaceRepository;
import com.springboot.todoapp.repositories.TodoItemRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoAndSpaceService {

    SpaceRepository spaceRepository;
    TodoItemRepository todoItemRepository;

    TodoAndSpaceService(SpaceRepository spaceRepository, TodoItemRepository todoItemRepository) {
        this.spaceRepository = spaceRepository;
        this.todoItemRepository = todoItemRepository;
    }

    public List<SpaceSummaryResponseDTO> getAllSpaces() {
        return spaceRepository.findAll().stream()
                .map(SpaceMapper::toSummaryDTO)
                .toList();
    }

    public SpaceSummaryResponseDTO createSpace(SpaceRequestDTO spaceRequestDTO) {
        Space space = SpaceMapper.toEntity(spaceRequestDTO);
        spaceRepository.save(space);
        return SpaceMapper.toSummaryDTO(space);
    }

    public TodoItemResponseDTO createTodo(@NotNull TodoItemRequestDTO todoItemRequestDTO, @NotNull Long spaceId) {
        Space space = spaceRepository.getReferenceById(spaceId);

        TodoItem todoItem = TodoItemMapper.toEntity(todoItemRequestDTO, space);
        TodoItem savedTodoItem = todoItemRepository.save(todoItem);
        return TodoItemMapper.toDTO(savedTodoItem);

    }

    public List<TodoItemResponseDTO> getTodoItemsForSpaceId(Long id) {
        return todoItemRepository.findAllBySpaceId(id)
                .stream()
                .map(TodoItemMapper::toDTO)
                .toList();
    }
}
