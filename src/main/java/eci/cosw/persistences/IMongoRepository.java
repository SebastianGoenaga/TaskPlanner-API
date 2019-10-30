package eci.cosw.persistences;

import java.util.List;

import eci.cosw.model.Todo;
import eci.cosw.model.User;
import eci.exception.TodoPlannerException;



public interface IMongoRepository {
    Todo getTodo(String id) throws TodoPlannerException;
    Todo saveTodo(Todo Todo);
    Todo updateTodo(Todo Todo);
    void removeTodo(String id);
    List<Todo> getTodos();
    List<Todo> getTodosByResponsable(String responsable);
    Todo assignTodoToUser(String TodoId, User user) throws TodoPlannerException;    
    User getUser(String responsable) throws TodoPlannerException;
    User saveUser(User user) throws TodoPlannerException;
    User updateUser(User user);
    void removeUser(String responsable);
    List<User> getUsers();
    
}
