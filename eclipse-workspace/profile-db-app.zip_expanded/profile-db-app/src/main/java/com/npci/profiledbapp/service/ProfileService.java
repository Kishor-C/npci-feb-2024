package com.npci.profiledbapp.service;

import java.util.List;

import com.npci.profiledbapp.beans.Profile;
import com.npci.profiledbapp.exceptions.ProfileNotFoundException;

public interface ProfileService {
	/*
	 * Methods to call ProfileDao methods
	 */
	public Profile store(Profile profile); // must call dao.save(profile)
	public Profile fetchProfile(int id) throws ProfileNotFoundException; // calls dao.findById(id)
	public List<Profile> findProfiles(); // calls dao.findAll()
	public Profile findProfile(long phone)throws ProfileNotFoundException; // calls dao.findPhone(phone)
	// below code calls findProfile(), setPhone(phone) and dao.save(profile)
	public Profile updateProfilePhone(int id, long phone)throws ProfileNotFoundException; 
	// below code calls dao.deleteById(id)
	public void deleteProfile(int id)throws ProfileNotFoundException;
	// below code to update the name by phone number
	public Profile updateNameByPhone(long phone, String name) throws ProfileNotFoundException;
}
