package com.sacrum.users.repository;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sacrum.users.domain.User;

/**
 * https://javabydeveloper.com/spring-jdbctemplate-query-examples/
 * @author Yusdel Morales Guevara
 *
 */

@Repository
public class UserRepository implements IUserRepository{
	
	/**
	 * Variables for OLD query methods
	 */
	
	PreparedStatement statement;
	
	/*
	 * È la connessione al database 
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * PostgreSQL nomina le sue tabelle con " " per questo nella creazione della queryString 
	 * bisogna usare il carattere di escape \ per passare i doppi apici.
	 * 
	 */
	@Override
	public User getUserById(String userID) {
		
//		SqlParameterSource parameters = new MapSqlParameterSource("ids", Integer.valueOf(userID));
//		String JPQL = "SELECT * FROM User WHERE userid in (:ids)";
//		user = jdbcTemplate.query(JPQL, parameters, new UserMapper());
		User user;
		Integer id = Integer.valueOf(userID);
		String JPQL = "SELECT * FROM \"User\" WHERE userid = ?";
		user = jdbcTemplate.query(JPQL, 
				new Object[] {id}, //parametri
				new int[] {Types.INTEGER}, //tipo dei parametri
				new UserMapper()).get(0);
		
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		
		String sql = "SELECT * FROM sp_getallusers()";
		
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		
		return users;
	}

	@Override
	public void InsertUser(User user) {
		String sql = "SELECT sp_insertuser('" + user.getName() + "')";
		jdbcTemplate.update(sql);
	}

	@Override
	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		
	}

}
