package com.example.todomanagement.service.impl;

import com.example.todomanagement.dto.TodoDto;
import com.example.todomanagement.entity.Todo;
import com.example.todomanagement.exception.ResourceNotFoundException;
import com.example.todomanagement.repository.TodoRepository;
import com.example.todomanagement.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;
    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        // convert TodoDto into Todo Jpa entity
        Todo todo = modelMapper.map(todoDto, Todo.class);

        // Todo Jpa entity
        Todo savedTodo = todoRepository.save(todo);

        // Convert saved Todo Jpa entity into TodoDto object
        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not fount with id:" + id));
        return modelMapper.map(todo, TodoDto.class);
    }
}
