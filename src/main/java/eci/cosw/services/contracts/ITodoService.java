package eci.cosw.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import eci.cosw.model.User;
import eci.cosw.model.Todo;
import eci.exception.TaskPlannerException;

@Service
public interface ITodoService {
	List<Todo> getTodosList();

	Todo getTodo(String responsable) throws TaskPlannerException;

	List<Todo> getTodosByUserId(String userId);

	Todo assignTodoToUser(String TodoId, User user) throws TaskPlannerException;

	void removeTodo(String TodoId);

	Todo updateTodo(Todo Todo);

	Todo createTodo(Todo Todo);
}