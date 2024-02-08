package com.npci.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.npci.dao.EmployeeDao;

public class TestService {

	public static void main(String[] args) {
		// consider this code is written in the service layer
		// referencing to the spring container which has all the objects
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		// when you get the object you must downcast to the right type
		// getBean is the factory pattern method that returns the object from the container
		// below code is abstracting the object that spring container is returning
		EmployeeDao employeeDao = (EmployeeDao)context.getBean("b1");
		employeeDao.store(); // you will see the output of store 
	}

}
