package com.npci.springws.service;

import java.util.List;

import com.npci.springws.beans.Profile;
import com.npci.springws.exceptions.ProfileNotFoundException;

public interface ProfileService {
	// store profile & return the stored profile
	public Profile store(Profile profile);
	// fetch all the profiles
	public List<Profile> fetchProfiles();
	// other methods must be provided
	// fetchProfile(int), updateProfile(int, Profile),
	// deleteProfile(int)
	// create a fetchProfile(int) that throws ProfileNotFoundException if profile is not 
	// found and returns Profile if 'id' is matching, call this method from the controller & test 
	// both the options both must show the details in JSON structure
	/*  
	 *  signature:
	 *  public Profile fetchProfile(int id) throws ProfileNotFoundException;
	 */
	public Profile fetchProfile(int id) throws ProfileNotFoundException;
}
