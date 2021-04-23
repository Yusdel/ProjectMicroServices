package com.sacrum.users.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Country implements Serializable{

	private static final long serialVersionUID = 5715771381513237582L;
	
	private Long countryID;
	private String country_name;
	private Long fk_nation;
	private Long fk_user;
}
