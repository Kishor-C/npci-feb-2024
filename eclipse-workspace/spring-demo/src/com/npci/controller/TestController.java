package com.npci.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.npci.service.EmployeeService;

// this is a dummy controller, in reality you will map the request and return the response
// but for demo purpose we are using main method 
public class TestController {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// controller needs service object, it must use service layer interface 
		EmployeeService service = (EmployeeService)context.getBean("b2");
		// above code gets the object of service that depends on the dao object
		service.save();
	}
	/*
	 * Comment the <property> tag in <bean id = "b2"> 
	 * Configure the bean with <constructor-arg> that supplies Dao to the Service
	 * Create a constructor in the Service that accepts dao as the parameter
	 * in <constructor-arg index = "0" ref = "b1" />
	 * Run this controller code which must give the output 
	 */
}
