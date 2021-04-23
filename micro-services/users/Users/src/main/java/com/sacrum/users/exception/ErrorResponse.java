package com.sacrum.users.exception;

import java.util.Date;

import lombok.Data;

/**
 * Classe per il salvataggio dei messaggi di errore.
 * 
 * @author Yusdel Morales Guevara
 *
 */
@Data
public class ErrorResponse {
	private Date data = new Date();
	private int codice;
	private String messaggio;
}
