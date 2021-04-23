package com.sacrum.users.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sacrum.users.domain.Nation;

public class NationMapper implements RowMapper<Nation>{

	@Override
	public Nation mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Nation nation = new Nation();
		
		try {
			nation.setNationID(rs.getLong("nationid"));
			nation.setNation_name(rs.getString("nation_name"));
		} catch (Exception e) {
			System.out.println("Errore in NationMapper.mapRow: " + e);
		}
		
		return nation;
	}
	
}
