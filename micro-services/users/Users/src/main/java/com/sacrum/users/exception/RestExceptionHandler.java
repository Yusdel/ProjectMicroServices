package com.sacrum.users.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * https://www.baeldung.com/spring-exceptions-json
 * Classe di gestione GENERALE delle eccezioni dei servizi REST del Server
 * 
 * @ControllerAdvice : notazione necessaria
 * @ExceptionHandler : Override exception 
 * 
 * @author Yusdel Morales Guevara
 *
 */

@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	/**
	 * NOT_FOUND exception error custom response
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ErrorResponse> ExceptionNotFoundHandler(Exception ex)
	{
		ErrorResponse errore = new ErrorResponse();
		
		errore.setCodice(HttpStatus.NOT_FOUND.value());
		errore.setMessaggio(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errore, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BindingException.class)
	public ResponseEntity<ErrorResponse> ExceptionBindingHandler(Exception ex)
	{
		ErrorResponse errore = new ErrorResponse();
		
		errore.setCodice(HttpStatus.BAD_REQUEST.value());
		errore.setMessaggio(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errore, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DuplicateException.class)
	public ResponseEntity<ErrorResponse> ExceptionDeplicateRecordHandler(Exception ex)
	{
		ErrorResponse errore = new ErrorResponse();
		
		errore.setCodice(HttpStatus.NOT_ACCEPTABLE.value());
		errore.setMessaggio(ex.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errore, HttpStatus.NOT_ACCEPTABLE);
    }
    
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> ExceptionHandler(Exception ex)
	{
		
		ErrorResponse errore = new ErrorResponse();
		
		errore.setMessaggio(ex.getMessage());
		errore.setCodice(HttpStatus.BAD_REQUEST.value());
		
		return new ResponseEntity<ErrorResponse>(errore, HttpStatus.BAD_REQUEST);
	}
}
