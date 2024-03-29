package com.npci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.npci.dao.EmployeeDao;
import com.npci.service.EmployeeService;
/*
 * @SpringBootApplication : automatically configures the application based
 * on the library you have in your project
 * ex: component scanning: recognizes @Component, @Service, @Repository...
 * ex: front-controller configuration
 */
@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
		// initially getting a dao object but later we will get service object
//		EmployeeDao dao = (EmployeeDao)context.getBean("employeeDaoV2");
//		dao.store();
		// write @Repository in V2 and get that object here to call store()
		EmployeeService service = (EmployeeService)context.getBean("employeeService");
		service.save(); // save >> calls >> dao.store()
	}

}
