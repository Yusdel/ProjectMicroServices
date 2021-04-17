package com.sacrum.users.domain;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.jdbc.support.GeneratedKeyHolder;

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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long userID;
	
	@Column
	private String name;
//	private String username;
//	private String mail;
//	private String phone_number;
//	private Date birthday;

}
