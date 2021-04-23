package com.sacrum.users.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * Classe per il salvataggio dei messaggi di errore.
 * @JsonFormat = Jackson parser 
 * > @param ( <pattern> = "dd-MM-yyyy'T'HH:mm:ss.SSSXXX", <timezone> = "Australia/Sydney" )
 * (È possibile inserire stringhe nel formato di ritorno mediante gli apici come: 'T')
 * 
 * @author Yusdel Morales Guevara
 *
 */
@Data
public class ErrorResponse {
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "Europe/Rome")
	private Date data = new Date();
	private int codice;
	private String messaggio;
}
