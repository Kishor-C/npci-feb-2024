package com.npci.profiledbapp.beans;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	
	// one to many associate with contact : List<Contact>
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pid")
	private List<Contact> contactsList; // generate setters & getters
	
	
	/*
	 * Generate setters and getters
	 */
	
	public List<Contact> getContactsList() {
		return contactsList;
	}
	public void setContactsList(List<Contact> contactsList) {
		this.contactsList = contactsList;
	}
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
