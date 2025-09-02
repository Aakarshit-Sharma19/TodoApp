package com.springboot.todoapp.repositories;

import com.springboot.todoapp.models.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findAllBySpaceId(Long spaceId);
}
