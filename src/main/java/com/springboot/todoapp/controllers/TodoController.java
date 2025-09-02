package com.springboot.todoapp.controllers;

import com.springboot.todoapp.models.dto.SpaceRequestDTO;
import com.springboot.todoapp.models.dto.SpaceSummaryResponseDTO;
import com.springboot.todoapp.models.dto.TodoItemRequestDTO;
import com.springboot.todoapp.models.dto.TodoItemResponseDTO;
import com.springboot.todoapp.service.TodoAndSpaceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final TodoAndSpaceService todoAndSpaceService;

    public TodoController(TodoAndSpaceService todoAndSpaceService) {
        this.todoAndSpaceService = todoAndSpaceService;
    }

    @PostMapping(value = "/spaces", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public SpaceSummaryResponseDTO createSpace(@Valid @RequestBody SpaceRequestDTO spaceRequestDTO) {
        return todoAndSpaceService.createSpace(spaceRequestDTO);
    }

    @GetMapping(value = "/spaces", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SpaceSummaryResponseDTO> getAllSpaces() {
        return todoAndSpaceService.getAllSpaces();
    }


    @PostMapping(value = "/spaces/{spaceId}/todos", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItemResponseDTO createTodo(@PathVariable Long spaceId, @Valid @RequestBody TodoItemRequestDTO todoItemRequestDTO) {
        return todoAndSpaceService.createTodo(todoItemRequestDTO, spaceId);
    }

    @GetMapping(value = "/spaces/{spaceId}/todos")
    public List<TodoItemResponseDTO> getAllTodoItemsForSpace(@PathVariable("spaceId") Long spaceId) {
        return todoAndSpaceService.getTodoItemsForSpaceId(spaceId);
    }
}
