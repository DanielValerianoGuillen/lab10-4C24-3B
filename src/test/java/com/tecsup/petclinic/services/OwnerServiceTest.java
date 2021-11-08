package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;


@SpringBootTest
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	@Autowired
	private OwnerService ownerService;

	
	
	public void testFindOwnerById() {

		long ID = 1;
		String NAME = "George";
		Owner owner = null;

		try {
			owner = ownerService.findById(ID);

		} catch (OwnerNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
		logger.info("" + owner);

		assertThat(NAME, is(owner.getFirstName()));

	}

	
	public void testCreateOwner() {

		 String FIRST_NAME = "Maria";
		 String LAST_NAME = "Escobito";
		 String ADDRESS = "345 Maple St.";
		 String CITY = "Madison";
		 String PHONE = "6085557683";

		Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, PHONE);
		Owner ownerCreated = ownerService.create(owner);
		logger.info("OWNER CREATED: " + ownerCreated);

		assertThat(ownerCreated.getId(), notNullValue());
		assertThat(ownerCreated.getFirstName(), is(FIRST_NAME));
		assertThat(ownerCreated.getLastName(), is(LAST_NAME));
		assertThat(ownerCreated.getAddress(), is(ADDRESS));
		assertThat(ownerCreated.getCity(), is(CITY));
		assertThat(ownerCreated.getTelephone(), is(PHONE));
	}

	
		
	 public void testUpdateOwner() {
		 String FIRST_NAME = "Maria";
		 String LAST_NAME = "Escobito";
		 String ADDRESS = "345 Maple St.";
		 String CITY = "Madison";
		 String PHONE = "6085557683";
		 long create_id = -1;
		 
		 String UP_FIRST_NAME = "Carlos";
		 String UP_LAST_NAME = "Estaban";
		 String UP_ADDRESS = "2335 Independence La.";
		 String UP_CITY = "Waunakee";
		 String UP_PHONE = "6085555487";
		 
		 Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, PHONE);
		 logger.info(">" + owner); 
		 Owner ownerCreated = ownerService.create(owner); 
		 logger.info(">>" + ownerCreated);
		 create_id = ownerCreated.getId();
		 ownerCreated.setFirstName(UP_FIRST_NAME);
		 ownerCreated.setLastName(UP_LAST_NAME); 
		 ownerCreated.setAddress(UP_ADDRESS);
		 ownerCreated.setCity(UP_CITY);
		 ownerCreated.setTelephone(UP_PHONE);
		 Owner upgradeOwner = ownerService.update(ownerCreated);
		 logger.info(">" + upgradeOwner);
		 assertThat(create_id ,notNullValue());
		 assertThat(upgradeOwner.getId(), is(create_id));
		 assertThat(upgradeOwner.getFirstName(), is(UP_FIRST_NAME));
		 assertThat(upgradeOwner.getLastName(), is(UP_LAST_NAME));
		 assertThat(upgradeOwner.getAddress(), is(UP_ADDRESS));
		 assertThat(upgradeOwner.getCity(), is(UP_CITY));
		 assertThat(upgradeOwner.getTelephone(), is(UP_PHONE));
	 }
	 /**
		 * 
		 */
	 
	 
	 	@Test
		public void testDeleteOwner() {
	
		 String FIRST_NAME = "Maria";
		 String LAST_NAME = "Escobito";
		 String ADDRESS = "345 Maple St.";
		 String CITY = "Madison";
		 String PHONE = "6085557683";

			Owner owner = new Owner(FIRST_NAME, LAST_NAME, ADDRESS, CITY, PHONE);
			owner = ownerService.create(owner);
			logger.info("" + owner);

			try {
				ownerService.delete(owner.getId());
			} catch (OwnerNotFoundException e) {
				assertThat(e.getMessage(), false);
			}
			try {
				ownerService.findById(owner.getId());
				assertThat(true, is(false));
			} catch (OwnerNotFoundException e) {
				assertThat(true, is(true));
			} 				

		}
}