package com.sacrum.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sacrum.users.domain.User;
import com.sacrum.users.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	UserService userService;
	
	/**
	 * 
	 */
	@GetMapping(value = "/")
	public @ResponseBody List<User> getAllUsers() {
		List<User> ret = userService.getAllUsers();
		
		return ret;
	}
	
	@RequestMapping(value = "/{userID}", produces = ("application/json"))
	public @ResponseBody User getUserByID(@PathVariable("userID") String userID){
		
		User ret = userService.getUserById(userID);
		
		return ret;
	}
	
	
}
