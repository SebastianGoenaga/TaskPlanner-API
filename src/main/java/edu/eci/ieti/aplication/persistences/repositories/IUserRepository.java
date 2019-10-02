package edu.eci.ieti.aplication.persistences.repositories;

import java.sql.SQLException;
import java.util.*;

import org.springframework.stereotype.Repository;

import edu.eci.ieti.aplication.model.User;

@Repository
public interface IUserRepository {
    public List<User> findAll() throws SQLException;

    public User findById(String id) throws SQLException;
}