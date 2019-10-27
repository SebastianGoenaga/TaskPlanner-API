package eci.cosw.persistences;

import java.util.List;

import eci.cosw.model.Todo;
import eci.cosw.model.User;
import eci.exception.TaskPlannerException;



public interface IMongoRepository {
	List<Todo> getTodos();

    List<Todo> getTodosByResponsable(String responsable);

    Todo getTodo(String id) throws TaskPlannerException;

    Todo saveTodo(Todo Todo);

    Todo updateTodo(Todo Todo);

    void removeTodo(String id);

    Todo assignTodoToUser(String TodoId, User user) throws TaskPlannerException;
    
    List<User> getUsers();

    User getUser(String responsable) throws TaskPlannerException;

    User saveUser(User user) throws TaskPlannerException;

    User updateUser(User user);

    void removeUser(String responsable);

}
