package com.sacrum.users.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {
	
	@GetMapping(value = "/")
	public @ResponseBody String home() {
		return "Hello World";
	}
	
}
