package com.npci.walletservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class WalletService {
	// auto-wire the rest template registered in the spring container
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private Client accountClient; // supplies the object of the FeignClient interface
	
	// a method that calls the remote service and returns the wallet 
	@CircuitBreaker(name = "getAccount", fallbackMethod = "getAccountDetails2")
	public Wallet getAccountDetails(long accountNumber) {
		System.out.println("_____ Making Remote Call _______");
		String URL = "http://ACCOUNT-SERVICE/account/"+accountNumber;
		// get the Account object from the remote service
		//Account account = rest.getForObject(URL, Account.class);
		// calling the remote service form the feign client
		Account account = accountClient.getAccount(accountNumber);
		// Initialize Wallet(name, walletBalance, total, account) from the Account
		Wallet wallet = new Wallet("MyPay", 500, (500+account.getBalance()), account);
		return wallet;
	}
	// fallback method that is automatically executed if the remote service is down
	public Wallet getAccountDetails2(long accountNumber, Throwable t) {
		System.out.println("_______ Fallback Method: Alternate Response ________");
		Wallet wallet = new Wallet("MyPay", 500, 0, null);
		return wallet;
	}
}
