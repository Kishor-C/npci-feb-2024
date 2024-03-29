package com.npci.springws.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.npci.springws.beans.Profile;
import com.npci.springws.exceptions.ProfileNotFoundException;
import com.npci.springws.service.ProfileService;

// we are going to handle profile data like id, name, dob, phone
// later, hence we are creating a profile controller

@RestController
@RequestMapping("/v1/api") // http://ip:port/v1/api
public class ProfileController {
	
	// ProfileController depends on the ProfileService
	@Autowired // injects the implementation of ProfileService
	private ProfileService service;
	
	// finds profile by id
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		try {
			Profile p = service.fetchProfile(id);
			return ResponseEntity.status(200).body(p);
		} catch(ProfileNotFoundException ex) {
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("errorMessage", ex.getMessage());
			return ResponseEntity.status(404).body(errorMap);
		}
	}
	
	// HTTP methods for different operations
	// produces is optional because by default it will be JSON
	@PostMapping(path = "/save", 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeApi(@RequestBody Profile profile) {
		//@RequestBody takes the JSON and maps to the profile object & initializes all the properties
		Profile p = service.store(profile);
		return ResponseEntity.status(201).body(p);
		// 201: HTTP status code for CREATE
	}
	// implement a web service that fetches the data from the service with appropriate HTTP method
	@GetMapping(path = "/findAll")
	public ResponseEntity<Object> fetchAllApi() {
		List<Profile> list = service.fetchProfiles();
		return ResponseEntity.status(200).body(list);
	}
	// below method is for testing webservice
	// ResponseEntity<T>: It is an object that can maintain http status code, content:T 
	// by default webservice produces JSON if have a java object in the response
	@GetMapping(path = "/greet/{username}")  // GET: http://ip:port/v1/api/greet
	public ResponseEntity<Object> greetings(
			@PathVariable("username") String name, 
			@RequestParam(value = "desig", required = false) String desig) {
		Map<String, Object> map = new HashMap<>();
		map.put("message", "Hello, REST username = "+name+", desig = "+desig);
		map.put("time", LocalDateTime.now());
		// 200: OK, 201: CREATED, 404: NOT FOUND
		// status: it accepts HTTP status code, body: it accepts the content of the response
		return ResponseEntity.status(200).body(map);
	}
}
