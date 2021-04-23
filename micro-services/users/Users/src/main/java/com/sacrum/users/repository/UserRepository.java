package com.sacrum.users.repository;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.sacrum.users.domain.User;

/**
 * https://javabydeveloper.com/spring-jdbctemplate-in-clause-with-list-of-values/
 * https://javabydeveloper.com/spring-jdbctemplate-query-examples/
 * @author Yusdel Morales Guevara
 *
 */

@Repository
public class UserRepository implements IUserRepository{
	
	/**
	 * Esistono diverse classi di creazione delle query.
	 * Le due sotto usate sono un esempio base per query base. 
	 * 
	 * <JdbcTemplate>
	 * <NamedParameterJdbcTemplate>
	 */
	
	@Autowired
	private JdbcTemplate jdbcTemplate; /* È la connessione al database */
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcNamedPar;
	
	@Override
	public User getUserById(Long userID) {
		// JdbcTemplate parameters on query example
		User user;
		/**
		 * PostgreSQL nomina le sue tabelle con " " per questo nella creazione della queryString 
		 * bisogna usare il carattere di escape \ per passare i doppi apici.
		 */
		String JPQL = "SELECT * FROM \"User\" WHERE userid = ?";
		try {
			
			user = jdbcTemplate.query(JPQL, 
					new Object[] {userID}, //parametri
					new int[] {Types.INTEGER}, //tipo dei parametri
					new UserMapper()).get(0);
			
		} catch (Exception e) {
			user = null;
		}
		
		return user;
	}
	
	@Override
	public List<User> getUserByFilter(User user) {
	
		List<User> ret = null;
		
		MapSqlParameterSource inQueryParams = new MapSqlParameterSource();

		String sql = "SELECT * FROM \"User\" WHERE (name = :name AND surname = :surname)";
			

		inQueryParams.addValue("name", user.getName(), Types.VARCHAR);
		inQueryParams.addValue("surname" , user.getSurname(), Types.VARCHAR);
		
		if (user.getMail()!=null && !user.getMail().isEmpty()) {
			sql += " OR mail = :mail";
			inQueryParams.addValue("mail" , user.getMail(), Types.VARCHAR);
		}
			
		sql += " LIMIT 1"; // LIMIT to get only 1 result
		
		try {
			
			ret = jdbcNamedPar.query(sql, inQueryParams, new UserMapper());
			
		} catch (Exception e) {
			// nothing
		}
		
		return ret;
	}

	@Override
	public List<User> getAllUsers() {
		// JdbcTemplate call Stored Pocedure on Postgres
		String sql = "SELECT * FROM sp_getallusers()";
		
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		
		return users;
	}

	@Override
	public void InsertUser(User user) {
		
		String sql = "INSERT INTO \"User\"(name, surname, mail, cell, birthday) VALUES ( :name, :surname, :mail, :cell, :birthday )";
		try {
			
			SqlParameterSource namedParameters = new MapSqlParameterSource()
					.addValue("name", user.getName(), Types.VARCHAR)
					.addValue("surname", user.getSurname(), Types.VARCHAR)
					.addValue("mail", user.getMail(), Types.VARCHAR)
					.addValue("cell", user.getPhone_number(), Types.VARCHAR)
					.addValue("birthday", user.getBirthday(), Types.DATE);
				
			jdbcNamedPar.update(sql, namedParameters);
			
		} catch (Exception e) {
			// returns the exception to the caller
			throw e;
		}	
	}
	
	@Override
	public int UpdateUser(User user) {
		int ret = 10;
		
		Map<String, Object> paramMap = new HashMap<String, Object>(); // method 2
		
		String sql = "UPDATE \"User\" SET ";
			
		// null params control
		if (user.getMail()!=null && !user.getMail().isEmpty()) {
			sql += " mail = :mail";
			paramMap.put("mail", user.getMail());
		}
			
		if (user.getName()!=null && !user.getName().isEmpty()) {
			sql += " name = :name";
			paramMap.put("name", user.getName());
		}
			
		if (user.getSurname()!=null && !user.getSurname().isEmpty()) {
			sql += " surname = :surname";
			paramMap.put("surname", user.getSurname());
		}
			
		if (user.getPhone_number()!=null && !user.getPhone_number().isEmpty()) {
			sql += " cell = :phone_number";
			paramMap.put("phone_number", user.getPhone_number());
		}
		
		if (user.getBirthday()!=null) {
			sql += " cell = :phone_number";
			paramMap.put("phone_number", user.getPhone_number());
		}
			
		sql += " WHERE userid = :userid";
		paramMap.put("userid", user.getUserID());
		
		try {
			
			jdbcNamedPar.update(sql, paramMap);
			
		} catch (Exception e) {
			
			ret = -1;
		}
		
		return ret;
	}

	@Override
	public void deleteUserById(String id) {
		
	}

}
