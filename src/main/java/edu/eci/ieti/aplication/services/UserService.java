package edu.eci.ieti.aplication.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import edu.eci.ieti.aplication.model.User;
import edu.eci.ieti.aplication.persistences.repositories.IUserRepository;
import edu.eci.ieti.aplication.services.contracts.IUserService;

@Component
public class UserService implements IUserService {

	@Autowired
	@Qualifier("MongoUserRepository")
	private IUserRepository userRepository;

	@Override
	public List<User> getUsersList() throws SQLException {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) throws SQLException {
		return userRepository.findById(userId);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(String userId) {
		// TODO Auto-generated method stub

	}
}
