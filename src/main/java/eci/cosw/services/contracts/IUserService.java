package eci.cosw.services.contracts;

import java.sql.SQLException;
import java.util.*;
import org.springframework.stereotype.Service;

import eci.cosw.model.User;
import eci.exception.TodoPlannerException;



@Service
public interface IUserService {
    User getUser(String responsable) throws TodoPlannerException;
    User createUser(User user) throws TodoPlannerException;
    User updateUser(User user) throws TodoPlannerException;
    void removeUser(String responsable) throws TodoPlannerException;
    List<User> getUsersList() throws SQLException;
}