package com.sacrum.users.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 
 * @author Yusdel Morales Guevara
 * 
 * {@summary}
 * Nello strato di Dominio, creiamo la correlazione tra classe e tabella!
 */

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 3801441617928282169L;
	
	private Long userID;
	private String name;
	private String surname;
	private String mail;
	private String phone_number;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date birthday;
	private Long fk_cvitae;

}
