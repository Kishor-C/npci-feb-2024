package com.npci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.npci.dao.EmployeeDao;
// even in service layer also we must have an interface with multiple service implementation
// for demo purpose we are not creating the service interface
@Service // spring creates object with an id - employeeService
public class EmployeeService {
	
	@Autowired // it injects the object
	@Qualifier(value = "employeeDaoV1")
	private EmployeeDao dao; // loosely coupled code
	
//	public EmployeeService(EmployeeDao dao) {
//		this.dao = dao;
//	}
	// EmployeeDaoV1 dao; tightly coupled code
	// EmployeeDaoV2 dao; tightly coupled code
	// generate setter method for dao
	// spring framework passes dao by internally calling setter with the help of <property>
	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}
	// caller to invoke store of Dao - this is still a dummy method
	public void save() {
		System.out.println("---- Service in save() is called -----");
		dao.store();
	}
	
}
