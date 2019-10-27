package eci.cosw.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import eci.cosw.model.Todo;
import eci.cosw.model.User;
import eci.cosw.persistences.IMongoRepository;
import eci.cosw.services.contracts.ITodoService;
import eci.exception.TaskPlannerException;




@Service
public class TodoService implements ITodoService {
	
	@Autowired
	private IMongoRepository TodoRepository;

	@Override
	public List<Todo> getTodosList() {
		// TODO Auto-generated method stub
		return TodoRepository.getTodos();
	}

	@Override
	public Todo getTodo(String responsable) throws TaskPlannerException {
		// TODO Auto-generated method stub
		return TodoRepository.getTodo(responsable);
	}

	@Override
	public List<Todo> getTodosByUserId(String responsable) {
		// TODO Auto-generated method stub
		return TodoRepository.getTodosByResponsable(responsable);
	}

	@Override
	public Todo assignTodoToUser(String TodoId, User user) throws TaskPlannerException {
		// TODO Auto-generated method stub
		return TodoRepository.assignTodoToUser(TodoId, user);
	}

	@Override
	public void removeTodo(String TodoId) {
		// TODO Auto-generated method stub
		TodoRepository.removeTodo(TodoId);
		
	}

	@Override
	public Todo updateTodo(Todo Todo) {
		// TODO Auto-generated method stub
		return TodoRepository.updateTodo(Todo);
	}

	@Override
	public Todo createTodo(Todo Todo) {
		// TODO Auto-generated method stub
		return TodoRepository.saveTodo(Todo);
	}



}