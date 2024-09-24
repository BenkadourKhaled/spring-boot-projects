package dz.todo.management.projects.controller;

import dz.todo.management.projects.dto.TodoDto;
import dz.todo.management.projects.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create By ${} on 22/09/2024
 *
 * @Author : KHALED_BENKADOUR
 * @Email : BENKKADOUR.KHALED@GMAIL.COM
 * @DATE : 22/09/2024
 * @TIME : 16:00
 * @Project_Name : spring-boot-projects
 */
@RestController
@RequestMapping(path = "/api/v1/todos")
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto) {
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long id) {
        TodoDto todoDto = todoService.getTodoById(id);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<TodoDto>> getTodoList() {
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto) throws ChangeSetPersister.NotFoundException {
        TodoDto updatedTodo = todoService.updateTodo(id, todoDto);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

}
