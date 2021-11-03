package com.tecsup.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;

public class OwnerServiceImpl {
	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceImpl.class);

	@Autowired
	OwnerRepository ownerRepository;

	public Owner create(Owner owner) {
		return ownerRepository.save(owner);
	}

	public Owner update(Owner owner) {
		return ownerRepository.save(owner);
	}

	
	public void delete(Long id) throws OwnerNotFoundException{

		Owner owner = findById(id);
		ownerRepository.delete(owner);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Owner findById(long id) throws OwnerNotFoundException {

		Optional<Owner> owner = ownerRepository.findById(id);

		if ( !owner.isPresent())
			throw new OwnerNotFoundException("Record not found...!");
			
		return owner.get();
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Owner> findByFirst_name(String first_name) {

		List<Owner> owners = ownerRepository.findByFirst_name(first_name);

		owners.stream().forEach(owner -> logger.info("" + owner));

		return owners;
	}



	public Iterable<Owner> findAll() {
		
		// TODO Auto-generated 
		return ownerRepository.findAll();
	}	
}
