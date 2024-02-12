package com.npci.springws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.npci.springws.beans.Profile;
import com.npci.springws.exceptions.ProfileNotFoundException;

@Service
public class ProfileServiceListImpl implements ProfileService {
	/*
	 * This will store the Profile in-memory instead of DB
	 */
	//List<Profile> to maintain the profile
	private static List<Profile> inMemoryDB = new ArrayList<>();

	@Override
	public Profile store(Profile profile) {
		inMemoryDB.add(profile);
		return profile; // return the stored profile
	}

	@Override
	public List<Profile> fetchProfiles() {
		return inMemoryDB; // return the List maintaining the profiles
	}

	@Override
	public Profile fetchProfile(int id) throws ProfileNotFoundException {
		// findFirst() returns Optional that internally handles null
		// orElseThrow(lambda): returns the object found or throws exception present in the lambda 
		return inMemoryDB
		.stream().filter(x -> x.getId() == id)
		.findFirst()
		.orElseThrow(() -> new ProfileNotFoundException("Sorry "+id+" not found"));
		// the above code can be written without streams as below
		/*
		for(Profile p : inMemoryDB) {
			if(p.getId() == id) {
				return p;
			}
		}
		throw new ProfileNotFoundException("Sorry "+id+" not found");
		*/
	}
}
