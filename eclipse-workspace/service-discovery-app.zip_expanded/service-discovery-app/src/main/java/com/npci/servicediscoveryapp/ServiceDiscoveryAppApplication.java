package com.npci.servicediscoveryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/*
 * This acts like service discovery - server port = 8761
 * we must use @EnableEurekaServer on top of the main class
 * we need to disable the client features like 
 * register with eureka = false
 * and another is fetch registry = false
 */
@SpringBootApplication
@EnableEurekaServer // this provides all the features a service discovery must have
public class ServiceDiscoveryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryAppApplication.class, args);
	}

}
