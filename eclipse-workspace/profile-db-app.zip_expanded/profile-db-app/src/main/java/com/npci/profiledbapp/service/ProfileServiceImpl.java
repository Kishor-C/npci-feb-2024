package com.npci.profiledbapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.npci.profiledbapp.beans.Profile;
import com.npci.profiledbapp.dao.ProfileDao;
import com.npci.profiledbapp.exceptions.ProfileNotFoundException;

@Service
public class ProfileServiceImpl implements ProfileService {

	// injecting the dao layer
	@Autowired
	private ProfileDao profileDao; // spring injects auto-implemented dao layer
	
	@Override
	public Profile store(Profile profile) {
		return profileDao.save(profile); // saves and returns the saved entity
	}

	@Override
	public Profile fetchProfile(int id) throws ProfileNotFoundException {
		// findById() returns Optional hence you can use orElseThrow
		// this returns Profile if found or else throws the exception
		return profileDao.findById(id)
				.orElseThrow(() -> new ProfileNotFoundException("Profile "+id+" not found"));
	}

	@Override
	public List<Profile> findProfiles() {
		//findAll() returns all the entities in the form of List<T>
		return profileDao.findAll();
	}

	@Override
	public Profile findProfile(long phone) throws ProfileNotFoundException {
		// dao has findByPhone that returns Optional
		return profileDao.findByPhone(phone)
				.orElseThrow(() -> new ProfileNotFoundException("Profile phone no: "+phone+" not found"));
	}

	@Override
	public Profile updateProfilePhone(int id, long phone) throws ProfileNotFoundException {
		Profile profile = fetchProfile(id);
		profile.setPhone(phone);
		return profileDao.save(profile); // save can update if the id is already present
	}

	@Override
	public void deleteProfile(int id) throws ProfileNotFoundException {
		Profile profile = fetchProfile(id);
		profileDao.delete(profile);
	}

	@Transactional // required when you use JPQL to update
	@Override
	public Profile updateNameByPhone(long phone, String name) throws ProfileNotFoundException {
		profileDao.updateNameByPhone(phone, name);
		return findProfile(phone);
		
	}
}
