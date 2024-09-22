package dz.todo.management.projects.repository;

import dz.todo.management.projects.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Todo findTodoById(Long id);
}