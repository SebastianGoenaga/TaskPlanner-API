package eci.cosw.persistences.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eci.cosw.model.Todo;
import eci.cosw.model.User;
import eci.cosw.persistences.IMongoRepository;
import eci.cosw.persistences.repositories.ITodoRepository;
import eci.cosw.persistences.repositories.IUserRepository;
import eci.exception.TodoPlannerException;

@Service
public class MongoRepositoryImp implements IMongoRepository {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ITodoRepository TodoRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(String responsable) throws TodoPlannerException {
		Optional<User> user = userRepository.findById(responsable);
		if (user.isPresent())
			return user.get();
		throw new TodoPlannerException(TodoPlannerException.NOT_FOUND);
	}

	@Override
	public User saveUser(User user) throws TodoPlannerException {
		if (userRepository.existsById(user.getEmail()))
			throw new TodoPlannerException(TodoPlannerException.USER_ALREADY_EXISTS);
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public void removeUser(String responsable) {
		userRepository.deleteById(responsable);

	}

	@Override
	public List<Todo> getTodos() {
		return TodoRepository.findAll();
	}

	@Override
	public List<Todo> getTodosByResponsable(String responsable) {
		return TodoRepository.findAllByOwner(responsable);
	}

	@Override
	public Todo getTodo(String id) throws TodoPlannerException {
		Optional<Todo> Todo = TodoRepository.findById(id);
		if (Todo.isPresent())
			return Todo.get();
		throw new TodoPlannerException(TodoPlannerException.NOT_FOUND);
	}

	@Override
	public Todo saveTodo(Todo Todo) {
		return TodoRepository.save(Todo);
	}

	@Override
	public Todo updateTodo(Todo Todo) {
		return TodoRepository.save(Todo);
	}

	@Override
	public void removeTodo(String id) {
		TodoRepository.deleteById(id);

	}

	@Override
	public Todo assignTodoToUser(String TodoId, User user) throws TodoPlannerException {
		Todo Todo = getTodo(TodoId);
		Todo.setResponsible(user.getEmail());
		return updateTodo(Todo);
	}

}
