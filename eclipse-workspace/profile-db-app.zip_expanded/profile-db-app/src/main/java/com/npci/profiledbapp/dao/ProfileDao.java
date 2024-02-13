package com.npci.profiledbapp.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.npci.profiledbapp.beans.Profile;

// extend JpaRepository, you get save(T), findAll(), findById(ID) and so on
// you can also create custom query methods which are also automatically implemented
public interface ProfileDao extends JpaRepository<Profile, Integer>{
	// inherits save(T) as save(Profile), findById(ID) as findById(Integer) and so on
	// findByPhone(long phone) must return an Optional<Profile> - this will be autoimplemented
	
	@Query("select p from Profile p where p.phone = ?1")
	public Optional<Profile> findByPhone(long phone);
	// service layer calls Optional<Profile> op = findByPhone()
	// op.orElseThrow(() => exception-object): returns profile or throws ProfileNotFoundException
}
