package com.npci.profiledbapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.profiledbapp.beans.Profile;
import com.npci.profiledbapp.exceptions.ProfileNotFoundException;
import com.npci.profiledbapp.service.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileControllerApi {
	// inject service layer
	@Autowired
	private ProfileService profileService;
	
	// storing the profile
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> storeApi(@RequestBody Profile profile) {
		// we can directly return ResponseEntity by storing the profile with HTTP status code 201
		return ResponseEntity.status(201).body(profileService.store(profile));
	}
	// finding the profile based on id
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> findApi(@PathVariable int id) {
		try {
			return ResponseEntity.status(200).body(profileService.fetchProfile(id));
		} catch(ProfileNotFoundException ex) {
			Map<String, String> map = new HashMap<>();
			map.put("errorMessage", ex.getMessage());
			return ResponseEntity.status(404).body(map);
		}
	}
}
