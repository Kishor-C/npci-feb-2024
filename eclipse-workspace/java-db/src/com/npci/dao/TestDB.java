package com.npci.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.Driver;

import com.npci.beans.Profile;

public class TestDB {

	public static void main(String[] args) {
		// storing some records with for loop
//		for(int i = 1; i <=5 ; i++) {
//			Profile p = new Profile("Profile:"+i, 9399393*i, LocalDate.now());
//			int status = save(p);
//			System.out.println("**** "+status+" row created ****");
//		}
		System.out.println("****Retriving all the records*****");
		List<Profile> list = findAll();
		list.forEach(item -> System.out.println("Id = "+item.getId()+", Name = "+item.getName()));
	}
	// findAll method that must return all the profile data in a collection
	public static List<Profile> findAll() {
		List<Profile> list = new ArrayList<>();
		try {
			//Loading the driver
			Class.forName(Driver.class.getName());// we can also use: forName("org.postgresql.Driver");
			//Establish the connection
			Connection connection = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/npci_db", "postgres", "Welcome@123");
			String sqlQuery = "select * from profile";
			// Creating the statement
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			//Execute the Query
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				Profile profile = new Profile(
						result.getString(2), result.getLong(3), result.getDate(4).toLocalDate());
				profile.setId(result.getInt(1));
				list.add(profile);
			}
			//Close the resources usually done in the finally block
			result.close();
			statement.close();
			connection.close();
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	// a save method that accepts profile object to store in the db
	public static int save(Profile profile) {
		// initially save returns 0 later returns the number rows updated
		int count = 0;
		// now we must load the driver, establish connection, prepare statement and run query
		try {
			//Loading the driver
			Class.forName(Driver.class.getName());// we can also use: forName("org.postgresql.Driver");
			//Establish the connection
			Connection connection = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/npci_db", "postgres", "Welcome@123");
			//Creating the statements
			String sqlQuery = "insert into profile(name, phone, dob) values(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlQuery);
			// set profile table values using getter methods of Profile object
			statement.setString(1, profile.getName()); // name of the profile object is set to name column
			statement.setLong(2, profile.getPhone()); // phone of the profile object is to phone column
			// import java.sql.Date not java.util.Date
			statement.setDate(3, Date.valueOf(profile.getDob())); // you don't have setLocalDate
			//Execute the query
			count = statement.executeUpdate(); // executeUpdate returns int
			//Close the resources usually done in the finally block
			statement.close();
			connection.close();
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
