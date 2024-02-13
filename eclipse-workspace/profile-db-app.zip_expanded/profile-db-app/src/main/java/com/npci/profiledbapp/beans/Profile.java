package com.npci.profiledbapp.beans;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {
	// @Id & @GeneratedValue is used on primary key variable
	@Id // this annotation is predefined, it is not related to name of the variable: id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // automatically maps to id column
	// name, phone, dob will not have @Id and @GeneratedValue
	private String name; // maps to name column
	private long phone; // maps to phone column
	private LocalDate dob; // maps to dob column
	/*
	 * Generate setters and getters
	 */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
}