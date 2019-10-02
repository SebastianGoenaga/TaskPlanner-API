package edu.eci.ieti.aplication.persistences;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.aplication.model.User;

/**
 * MongoUserRepository
 */
public interface MongoUserRepository extends MongoRepository<User, String> {

    

}