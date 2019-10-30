package eci.cosw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import eci.cosw.model.Todo;
import eci.cosw.model.User;
import eci.cosw.persistences.IMongoRepository;
import eci.cosw.services.contracts.ITodoService;
import eci.exception.TodoPlannerException;

@Service
public class TodoService implements ITodoService {

	@Autowired
	private IMongoRepository TodoRepository;

	@Override
	public List<Todo> getTodosList() {
		return TodoRepository.getTodos();
	}

	@Override
	public Todo getTodo(String responsable) throws TodoPlannerException {
		return TodoRepository.getTodo(responsable);
	}

	@Override
	public List<Todo> getTodosByUserId(String responsable) {
		return TodoRepository.getTodosByResponsable(responsable);
	}

	@Override
	public Todo assignTodoToUser(String TodoId, User user) throws TodoPlannerException {
		return TodoRepository.assignTodoToUser(TodoId, user);
	}

	@Override
	public void removeTodo(String TodoId) {
		TodoRepository.removeTodo(TodoId);

	}

	@Override
	public Todo updateTodo(Todo Todo) {
		return TodoRepository.updateTodo(Todo);
	}

	@Override
	public Todo createTodo(Todo Todo) {
		return TodoRepository.saveTodo(Todo);
	}

}