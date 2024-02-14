package com.npci.firstmsapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first/api")
public class FMSController {

	@GetMapping
	public String greet() {
		return "Hello, This is a microservice";
	}

}
