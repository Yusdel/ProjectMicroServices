package com.morales.reserved.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:4200") //chiamante
public class IndexController {

	@GetMapping(value = "/", produces = "application/json")
	public String home() {
		return "hello world";
	}
}
