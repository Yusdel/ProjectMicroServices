package com.sacrum.users.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sacrum.users.domain.CVitae;

public class CVitaeMapper implements RowMapper<CVitae>{

	@Override
	public CVitae mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CVitae cvitae = new CVitae();
		try {
			cvitae.setCvitaeID(rs.getLong("cvitaeid"));
			cvitae.setIntroduction(rs.getString("introduction"));
			
		} catch (Exception e) {
			System.out.println("Errore in CVitaeMapper.mapRow: " + e);
		}
		return cvitae;
	}

}
