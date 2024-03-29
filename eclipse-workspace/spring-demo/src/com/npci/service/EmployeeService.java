package com.npci.service;

import com.npci.dao.EmployeeDao;
// even in service layer also we must have an interface with multiple service implementation
// for demo purpose we are not creating the service interface
public class EmployeeService {
	private EmployeeDao dao; // loosely coupled code
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
