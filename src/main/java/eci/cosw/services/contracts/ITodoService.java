package eci.cosw.services.contracts;

import java.util.List;

import org.springframework.stereotype.Service;

import eci.cosw.model.User;
import eci.cosw.model.Todo;
import eci.exception.TodoPlannerException;

@Service
public interface ITodoService {
	Todo getTodo(String responsable) throws TodoPlannerException;
	Todo assignTodoToUser(String TodoId, User user) throws TodoPlannerException;
	void removeTodo(String TodoId);
	Todo updateTodo(Todo Todo);
	Todo createTodo(Todo Todo);
	List<Todo> getTodosList();
	List<Todo> getTodosByUserId(String userId);

}