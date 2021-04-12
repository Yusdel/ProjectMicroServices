package com.privatearea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
	
	@GetMapping(value = "/")
	public String home() {
		return "Hello World";
	}
}
