package com.npci;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestStreams {

	public static void main(String[] args) {
		// creating an immutable List having some employees
		List<Employee> employees = List.of(
				new Employee(500, "Charles", 78000, LocalDate.parse("2000-12-20")),
				new Employee(200, "Babu", 88000, LocalDate.parse("2002-12-20")),
				new Employee(300, "Manju", 99000, LocalDate.parse("2003-12-20")),
				new Employee(600, "David", 23000, LocalDate.parse("2002-12-20")),
				new Employee(700, "Ajay", 98000, LocalDate.parse("2004-12-20")),
				new Employee(100, "Vijay", 75000, LocalDate.parse("1999-12-20")),
				new Employee(900, "Amith", 70000, LocalDate.parse("1998-12-20")),
				new Employee(900, "Raj", 71000, LocalDate.parse("1997-12-20"))
				);
		// Streams make data processing simpler because it works in-memory without changing the
		// existing data-structure, most of the stream methods take functional interface - lambda
		// filter(Predicate): Predicate has a method: boolean test(T t) : x -> x > 20
		// forEach(Consumer): It is to iterate elements: Consumer has method: void accept(T t)
		// forEach( x-> System.out.println(x))
		// print employees who have salary > 75k
		System.out.println("----- Employees having salary > 75000 ------");
		employees.stream().filter(x -> x.getSalary() > 75000).forEach(x -> System.out.println(x));
		// stream has not modified the existing datastructure
		System.out.println("----- Print all the employees -----");
		employees.forEach(x -> System.out.println(x));
		// copying from one datastructure to another : you must use 
		// collect(Collectors.toSet()), collect(Collectors.toList())
		System.out.println("---- Copying the List to Set -----");
		Set<Employee> employeeSet = employees.stream().collect(Collectors.toSet());
		System.out.println("---- Print the set using forEch ----");
		employeeSet.forEach(x -> System.out.println(x));
		// applying multiple filters : filter().filter().filter()
		// apply multiple filter: that gives employees having salary > 70000 and doj > 2000
		System.out.println("--- Multiple filters -----");
		employees.stream().filter(x -> x.getSalary() > 70000)
		.filter(x -> x.getDoj().getYear() > 2000).forEach(x -> System.out.println(x));
		// applying the map to transform 
		// getting only the name of the employees in a separate list
		System.out.println("---- Transform Employee to String ----");
		// map(Function): Function has a method: R apply(T t): 
		// Here R can be some type & T can be some type
		List<String> names = employees.stream().map(x -> x.getName()).collect(Collectors.toList());
		names.forEach(x -> System.out.println(x));
		System.out.println("---- Transform Employee to Double with some increase in salary ---");
		List<Double> increasedSalary = employees.stream()
				.map(x -> x.getSalary() * 1.1).collect(Collectors.toList());
		increasedSalary.forEach(x -> System.out.println(x));
		// applying map to get employees with increased salary by 10% in a new List
		List<Employee> employeesWithIncrSalary = employees.stream()
				.map(x -> new Employee(x.getId(), x.getName(), x.getSalary()*1.1, x.getDoj()))
				.collect(Collectors.toList());
		System.out.println("--- Employees with new salary ------");
		employeesWithIncrSalary.forEach(x -> System.out.println(x));
		System.out.println("--- Sorting employees ---");
		employees.stream().sorted().forEach(item -> System.out.println(item));
		System.out.println("--- Sorting with Comparator -----");
		employees.stream()
		.sorted((x, y) -> x.getName().compareTo(y.getName()))
		.forEach(item -> System.out.println(item));
	}
	
}
