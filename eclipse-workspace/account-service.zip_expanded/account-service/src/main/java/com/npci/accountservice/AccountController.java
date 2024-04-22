package com.npci.accountservice;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/account")
@RestController
public class AccountController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping(path = "/{accountNumber}")
	public ResponseEntity<Object> getBalance(@PathVariable("accountNumber") long accountNumber) {
		// in real time we need to fetch the balance from the account number, but now we will
		// randomly generate the balance from the account number
		double balance = (Math.random() * 12345) + accountNumber;
		balance = Math.ceil(balance); // round up the number
		// a map that will send account number, balance & the port number
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("account", accountNumber);
		map.put("balance", balance);
		map.put("port", port);
		// pass the map to the response body
		return ResponseEntity.status(200).body(map);
	}

}
