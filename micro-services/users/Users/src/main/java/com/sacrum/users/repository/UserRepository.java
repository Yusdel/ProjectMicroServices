package com.sacrum.users.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sacrum.users.domain.User;

@Repository
public class UserRepository implements IUserRepository{
	
	/*
	 * È la connessione al database 
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User getUserById(String id) {
		
		String query = "Select * FROM Users WHERE id = '" + id + "'";
		return null;
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
