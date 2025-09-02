package com.springboot.todoapp.models.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spaces")
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "space_name", nullable = false)
    private String spaceName;
    @OneToMany(mappedBy = "space", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TodoItem> todoItems = new HashSet<>();

    public Space() {
    }

    public Space(String spaceName) {
        this.spaceName = spaceName;
    }

    public Space(Long id, String spaceName){
        this.id = id;
        this.spaceName = spaceName;
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

    public Set<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(Set<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public void addTodoItem(TodoItem todoItem) {
        todoItems.add(todoItem);
        todoItem.setSpace(this);
    }

    public void removeTodoItem(TodoItem todoItem) {
        todoItems.remove(todoItem);
        todoItem.setSpace(null);
    }

}
