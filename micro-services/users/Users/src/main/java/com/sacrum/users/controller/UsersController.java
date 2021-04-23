package com.sacrum.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sacrum.users.domain.User;
import com.sacrum.users.exception.NotFoundException;
import com.sacrum.users.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * ResponseEntity<class> trasforma la classe passata nel Diamond Operator (< >) in JSON. 
 * ( Di norma si passano le clasi Entity o Domain )
 * 
 * NotFoundException : Custom exception
 * 
 * @author Yusdel Morales Guevara
 *
 */

@RestController
@Slf4j
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ResourceBundleMessageSource errMessage;
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<User>> getAllUsers() {
		
		List<User> users = userService.getAllUsers();
		
		if(users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{userID}", produces = ("application/json"))
	public ResponseEntity<User> getUserByID(@PathVariable("userID") String userID) throws NotFoundException{
		
		User user = userService.getUserById(userID);
		
		if(user==null) {
			//return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			
			String errMsg = String.format("Non risulta uno user registrato con ID: %s", userID);
			throw new NotFoundException(errMsg);
		}
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	/* ResponseEntity<?> = non c'è alcun valore generico di ritorno */
	@PostMapping(value = "/create")
	public ResponseEntity<?> createUser(@RequestBody User user)
	throws Exception {
		
		List<User> checkUser = userService.getUserByFilter(user);
		
		if(checkUser != null && checkUser.size()>0) {
			String MsgErr = String.format("Utente %s presente in anagrafica! "
					+ "Impossibile utilizzare il metodo POST!", user.getName());
			
			log.warn(MsgErr);
			
			throw new Exception(MsgErr);
		}
		
		userService.InsertUser(user);
		
		HttpHeaders headers = new HttpHeaders();
		ObjectMapper mapper = new ObjectMapper();
		
		headers.setContentType(MediaType.APPLICATION_JSON);

		ObjectNode responseNode = mapper.createObjectNode();
		
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Inserimento/Modifica user " + 
				user.getName() + " " + user.getSurname() + 
				" eseguito con successo");

		return new ResponseEntity<>(responseNode, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	public ResponseEntity<?> updateArt(@RequestBody User user,
				UriComponentsBuilder ucBuilder) throws Exception  
	{
		
		List<User> checkArt =  userService.getUserByFilter(user);

		if (checkArt == null)
		{
			String MsgErr = String.format("Articolo %s non presente in anagrafica! "
					+ "Impossibile utilizzare il metodo PUT", user.getName());
			
			log.warn(MsgErr);
			
			throw new Exception(MsgErr);
		}
		
		HttpHeaders headers = new HttpHeaders();
		ObjectMapper mapper = new ObjectMapper();
		
		headers.setContentType(MediaType.APPLICATION_JSON);

		ObjectNode responseNode = mapper.createObjectNode();

		userService.UpdateUser(user);
		
		responseNode.put("code", HttpStatus.OK.toString());
		responseNode.put("message", "Modifica Articolo " + user.getName() + " Eseguita Con Successo");

		return new ResponseEntity<>(responseNode, headers, HttpStatus.CREATED);
	}
	
}
