package dz.todo.management.projects.service.impl;

import dz.todo.management.projects.dto.TodoDto;
import dz.todo.management.projects.entity.Todo;
import dz.todo.management.projects.repository.TodoRepository;
import dz.todo.management.projects.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
/**
 * Create By ${} on 22/09/2024
 *
 * @Author : KHALED_BENKADOUR
 * @Email : BENKKADOUR.KHALED@GMAIL.COM
 * @DATE : 22/09/2024
 * @TIME : 15:49
 * @Project_Name : spring-boot-projects
 */

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        return modelMapper.map(todoRepository.save(modelMapper.map(todoDto, Todo.class)), TodoDto.class);
    }

    @Override
    public TodoDto getTodoById(Long id) {
        Todo todo = todoRepository.findTodoById(id);
        return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) throws ChangeSetPersister.NotFoundException {
        Todo oldTodo = todoRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        oldTodo.setTitle(todoDto.getTitle());
        oldTodo.setDescription(todoDto.getDescription());
        oldTodo.setCompleted(todoDto.isCompleted());
        return modelMapper.map(todoRepository.save(oldTodo), TodoDto.class);
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class)).collect(toList());
    }

    @Override
    public void deleteTodo(Long id) throws ChangeSetPersister.NotFoundException {
        Todo oldTodo = todoRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        todoRepository.deleteById(oldTodo.getId());
    }

    @Override
    public TodoDto completeTodo(Long id) throws ChangeSetPersister.NotFoundException {
        Todo oldTodo = todoRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        oldTodo.setCompleted(Boolean.TRUE);
        return modelMapper.map(todoRepository.save(oldTodo), TodoDto.class);
    }
}
