package com.sacrum.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe per la gestione della ricerca, fallita, degli/dello User 
 * 
 * @author Yusdel Morales Guevara
 *
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Inesistente")
public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 2055585927461821763L;
	private String userID;

	public UserNotFoundException(String userid)
	{
		this.userID = userid;
	}

	public String getUserID()
	{
		return userID;
	}
}
