package com.example.asynchdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService service;
	
	// method that calls synchronous code which uses the same thread to 
	// handle request & generate response
	@GetMapping(path = "/synch", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUser1() {
		return service.getUsersSynch();
	}
	
	// method that calls asynchronous code which uses different thread to handle
	// request & generate the response
	@GetMapping(path = "/asynch", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<User> getUser2() {
		return service.getUsersAsynch();
	}
	/*
	 * Access these webservices from the browser
	 */
}
