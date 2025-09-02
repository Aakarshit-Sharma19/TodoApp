package com.springboot.todoapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.todoapp.models.dto.SpaceRequestDTO;
import com.springboot.todoapp.models.dto.SpaceSummaryResponseDTO;
import com.springboot.todoapp.models.dto.TodoItemRequestDTO;
import com.springboot.todoapp.models.dto.TodoItemResponseDTO;
import com.springboot.todoapp.service.TodoAndSpaceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TodoAndSpaceService todoAndSpaceService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createSpace_shouldReturnCreatedSpace() throws Exception {
        SpaceRequestDTO requestDTO = new SpaceRequestDTO("Test Space");
        SpaceSummaryResponseDTO responseDTO = new SpaceSummaryResponseDTO(1L, "Test Space");

        given(todoAndSpaceService.createSpace(any(SpaceRequestDTO.class))).willReturn(responseDTO);

        var res = mockMvc.perform(post("/spaces")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.spaceName", is("Test Space")));
    }

    @Test
    void getAllSpaces_shouldReturnListOfSpaces() throws Exception {
        SpaceSummaryResponseDTO space = new SpaceSummaryResponseDTO(1L, "Test Space");
        given(todoAndSpaceService.getAllSpaces()).willReturn(Collections.singletonList(space));

        mockMvc.perform(get("/spaces"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].spaceName", is("Test Space")));
    }

    @Test
    void createTodo_shouldReturnCreatedTodo() throws Exception {
        TodoItemRequestDTO requestDTO = new TodoItemRequestDTO("Test Todo", false);
        TodoItemResponseDTO responseDTO = new TodoItemResponseDTO(1L, "Test Todo", false);

        given(todoAndSpaceService.createTodo(any(TodoItemRequestDTO.class), anyLong())).willReturn(responseDTO);

        mockMvc.perform(post("/spaces/1/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.description", is("Test Todo")));
    }

    @Test
    void getAllTodoItemsForSpace_shouldReturnListOfTodos() throws Exception {
        TodoItemResponseDTO todo = new TodoItemResponseDTO(1L, "Test Todo", false);
        given(todoAndSpaceService.getTodoItemsForSpaceId(anyLong())).willReturn(Collections.singletonList(todo));

        mockMvc.perform(get("/spaces/1/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description", is("Test Todo")));
    }
}