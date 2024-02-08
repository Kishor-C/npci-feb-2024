package com.npci.dao;

import org.springframework.stereotype.Repository;

 // spring creates the object of this class
// by default its id is same as class name but first letter will be in lowercase
// i.e., employeeDaoV1 is the id
@Repository
public class EmployeeDaoV1 implements EmployeeDao{

	@Override
	public void store() {
		System.out.println("---- store() inside V1 ----");
	}
	
}
