package com.npci;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestEmployees {
	public static void main(String[] args) {
		// adding the employees in a java.util.List<Employee> 
		List<Employee> list = new ArrayList<>();
		// creating an object of employee & adding
		// ISO format of Date yyyy-MM-dd
		Employee employee1 = new Employee(100, "Alex", 50000, LocalDate.parse("2001-12-15")); 
		list.add(employee1); // adding the reference
		// adding directly the object without reference
		list.add(new Employee(300, "Charles", 80000, LocalDate.parse("2002-11-14")));
		list.add(new Employee(200, "Brad", 90000, LocalDate.parse("2005-11-14")));
		list.add(new Employee(500, "David", 70000, LocalDate.parse("1999-12-14")));
		list.add(new Employee(400, "Edward", 50000, LocalDate.parse("1998-11-14")));
		
		// iterating the list using for - each loop :: for(type t : collection)
		print(list);
		list.remove(3);
		print(list);
		// applying sort logic using Comparator with lambda expression.
		// we can use the lambda expression with reference & pass it as a parameter
		Comparator<Employee> compareById = (e1, e2) -> e1.getId() - e2.getId();
		System.out.println("------ Sorting based on id ------");
		list.sort(compareById);
		print(list);
		// we can also pass lambda expression directly to the sort method without reference
		System.out.println("----- Sorting based on salary ----");
		list.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		print(list);
		// apply lambda expression for doj in both ascending & descending and print them
		System.out.println("---- Sorting based on doj in descending order ---");
		list.sort((e1, e2) -> e2.getDoj().compareTo(e1.getDoj()));
		print(list);
		/*
		 * Set implementation to store only unique elements
		 * Note: for complex type you must override 2 methods of Object class: equals & hashCode
		 * hashCode: Tells the location of the object
		 * equals: Compares two objects to identify the duplicates
		 */
		Set<Employee> set = new HashSet<>(); 
		set.add(new Employee(200, "Alex", 50000, LocalDate.parse("2000-11-25")));
		set.add(new Employee(200, "Alex", 50000, LocalDate.parse("2000-11-25")));
		set.add(new Employee(300, "Alex", 80000, LocalDate.parse("2001-11-25")));
		set.add(new Employee(100, "Bruce", 90000, LocalDate.parse("2000-11-25")));
		System.out.println("----- Elements in HashSet ------");
		print(set);
	}
	public static void print(Collection<Employee> collection) {
		System.out.println("------ Printing all the employees ----------");
		for(Employee e : collection) {
			System.out.println(e);
		}
	}
}
