package com.npci.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoV2 implements EmployeeDao{

	@Override
	public void store() {
		System.out.println("---- store() inside V2 ----");
	}
	
}
