package dz.todo.management.projects.service;

import dz.todo.management.projects.dto.TodoDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

/**
 * Create By ${} on 22/09/2024
 *
 * @Author : KHALED_BENKADOUR
 * @Email : BENKKADOUR.KHALED@GMAIL.COM
 * @DATE : 22/09/2024
 * @TIME : 15:47
 * @Project_Name : spring-boot-projects
 */
public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);
    List<TodoDto> getAllTodos();
    TodoDto getTodoById(Long id);
    TodoDto updateTodo(Long id, TodoDto todoDto) throws ChangeSetPersister.NotFoundException;
}
