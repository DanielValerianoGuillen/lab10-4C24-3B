package com.tecsup.petclinic.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tecsup.petclinic.entities.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
	// Fetch pets by name
		List<Owner> findByFirst_name(String name);


		
}
