package com.sacrum.users.exception;

/**
 * Classe per la gestione della ricerca, fallita, degli/dello User 
 * 
 * @author Yusdel Morales Guevara
 *
 */
public class NotFoundException extends Exception{
	
	private static final long serialVersionUID = -1230279965738144538L;
	private static String default_response_message = "Elemento non Trovato!";
	private String messaggio = "";
	
	public NotFoundException()
	{
		super(default_response_message);
	}
	
	public NotFoundException(String Messaggio)
	{
		super(Messaggio);
		this.messaggio = Messaggio;
	}

	public String getMessaggio()
	{
		return messaggio;
	}

	public void setMessaggio(String messaggio)
	{
		this.messaggio = messaggio;
	}
}
