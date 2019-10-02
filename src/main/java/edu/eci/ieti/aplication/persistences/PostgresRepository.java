package edu.eci.arem.springAplication.persistences;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.arem.springAplication.model.Test;
import edu.eci.arem.springAplication.persistences.repositories.ITestRepository;

@Component
public class PostgresRepository implements ITestRepository {


	@Autowired
	private DataSource dataSource;

	@Override
	public List<Test> findAll() throws SQLException {
		String query = "SELECT * FROM prueba;";
		List<Test> test = new ArrayList<Test>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Test test1 = new Test();
				test1.setId(rs.getString("id"));
				test.add(test1);
			}
			connection.close();
			return test;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}

	}
}