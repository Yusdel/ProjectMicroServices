package com.sacrum.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sacrum.users.domain.User;
import com.sacrum.users.service.UserService;

@RestController
@RequestMapping("/api/users/")
public class IndexController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/")
	public @ResponseBody List<User> home() {
		List<User> ret = userService.getAllUsers();
		
		return ret;
		//return "Hello World";
	}
	
	@GetMapping(value = "/add")
	public @ResponseBody List<User> getAllUser(){
		
		List<User> ret = userService.getAllUsers();
		
		return ret;
	} 
}
