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
import eci.exception.TaskPlannerException;


@Service
public class MongoRepositoryImp implements IMongoRepository {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private ITodoRepository TodoRepository;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser(String responsable) throws TaskPlannerException {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(responsable);
		if (user.isPresent())
			return user.get();
		throw new TaskPlannerException(TaskPlannerException.NOT_FOUND);
	}

	@Override
	public User saveUser(User user) throws TaskPlannerException {
		// TODO Auto-generated method stub
		if (userRepository.existsById(user.getEmail()))
			throw new TaskPlannerException(TaskPlannerException.USER_ALREADY_EXISTS);
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public void removeUser(String responsable) {
		// TODO Auto-generated method stub
		userRepository.deleteById(responsable);

	}
	@Override
	public List<Todo> getTodos() {
		// TODO Auto-generated method stub
		return TodoRepository.findAll();
	}

	@Override
	public List<Todo> getTodosByResponsable(String responsable) {
		// TODO Auto-generated method stub
		return TodoRepository.findAllByOwner(responsable);
	}

	@Override
	public Todo getTodo(String id) throws TaskPlannerException {
		// TODO Auto-generated method stub
		Optional<Todo> Todo = TodoRepository.findById(id);
		if (Todo.isPresent())
			return Todo.get();
		throw new TaskPlannerException(TaskPlannerException.NOT_FOUND);
	}

	@Override
	public Todo saveTodo(Todo Todo) {
		// TODO Auto-generated method stub
		return TodoRepository.save(Todo);
	}

	@Override
	public Todo updateTodo(Todo Todo) {
		// TODO Auto-generated method stub
		return TodoRepository.save(Todo);
	}

	@Override
	public void removeTodo(String id) {
		// TODO Auto-generated method stub
		TodoRepository.deleteById(id);

	}

	@Override
	public Todo assignTodoToUser(String TodoId, User user) throws TaskPlannerException {
		// TODO Auto-generated method stub
		Todo Todo = getTodo(TodoId);
		Todo.setResponsible(user.getEmail());
		return updateTodo(Todo);
	}

}
