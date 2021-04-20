package com.sacrum.users.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sacrum.users.domain.User;

/**
 * Preleva il Record-Set ottenuto dal JDBC e lo mappa con la nostra classe di "domain".
 * I Valori di ritorno dalla Classe UserRepository vengono mappati nella classe User di dominio, così
 * da convertire il result delle querry in oggetti Java.
 * @author Yusdel Morales Guevara
 *
 */
public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		User user = new User();
		try {
			user.setUserID(rs.getLong("userid"));
			user.setName(rs.getString("name"));
			user.setSurname(rs.getString("surname"));
			user.setMail(rs.getString("mail"));
			user.setPhone_number(rs.getString("cell"));
		} catch (Exception e) {
			System.out.println("Errore in UserMapper.mapRow: " + e);
		}
		return user;
	}

}
