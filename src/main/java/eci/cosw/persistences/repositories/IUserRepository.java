package eci.cosw.persistences.repositories;

import java.util.*;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eci.cosw.model.User;





@Repository
public interface IUserRepository extends MongoRepository<User, String> {
    public List<User> findAll();
}