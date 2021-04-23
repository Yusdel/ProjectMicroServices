package com.sacrum.users.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sacrum.users.domain.Country;

public class CountryMapper implements RowMapper<Country>{

	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Country country = new Country();
		
		try {
			country.setCountryID(rs.getLong("countryid"));
			country.setCountry_name(rs.getString("country_name"));
			country.setFk_nation(rs.getLong("fk_nation"));
			country.setFk_user(rs.getLong("fk_user"));
		} catch (Exception e) {
			System.out.println("Errore in CountryMapper.mapRow: " + e);
		}
		
		return country;
	}

}
