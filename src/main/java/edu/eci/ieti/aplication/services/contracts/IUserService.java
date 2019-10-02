package edu.eci.ieti.aplication.services.contracts;

import java.sql.SQLException;
import java.util.*;
import org.springframework.stereotype.Service;

import edu.eci.ieti.aplication.model.User;

@Service
public interface IUserService {
    List<User> getUsersList() throws SQLException;

    User getUserById(String userId) throws SQLException;

    User createUser(User user) throws SQLException;

    User updateUser(User user) throws SQLException;

    void removeUser(String userId) throws SQLException;
}
