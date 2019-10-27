package eci.cosw.persistences.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import eci.cosw.model.Todo;




public interface ITodoRepository extends MongoRepository<Todo, String> {
	 List<Todo> findAllByOwner(String responsable);


}
