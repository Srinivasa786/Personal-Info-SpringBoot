package com.mars.poc.person.info.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.mars.poc.person.info.domain.Person;
import com.mars.poc.person.info.exception.ResourceNotFoundException;
import com.mars.poc.person.info.service.AddressService;
import com.mars.poc.person.info.service.PersonService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class PersonControllerTest {

	@InjectMocks
	PersonController personController;

	@Mock
	PersonService personService;

	@Mock
	AddressService addressService;

	
	@Test
	public void testGetAllPersons()  throws Exception {
		List<Person> persons = new ArrayList<Person>();
		Person person = new Person();
		person.setFirstName("Srinivas");
		person.setLastName("Duggempudi");
		person.setPersonID(Long.valueOf(101));
		persons.add(person);
		Mockito.when(personService.getAllPersons()).thenReturn(persons);
		List<Person> result = personController.getAllPersons();
		assertNotNull(result);

	}

	@Test
	public void  testGetPersonById() throws Exception {
	
	Person person = new Person();
	person.setFirstName("Srinivas");
	person.setLastName("Duggempudi");
	person.setPersonID(Long.valueOf(101));
	
	Mockito.when(personService.getPersonById(ArgumentMatchers.any())).thenReturn(person);
	 ResponseEntity<Person> result = personController.getPersonById(Long.valueOf(101));
	 assertThat(result.getBody().getFirstName()).isEqualTo("Srinivas");

	}
	
	@Test
	public void testCreatePerson() {
		Person person = new Person();
		person.setFirstName("Srinivas");
		person.setLastName("Duggempudi");
		person.setPersonID(Long.valueOf(101));
		Mockito.when(personService.createPerson(ArgumentMatchers.any())).thenReturn(person);
		Map<String, Boolean> result = personController.createPerson(person);
		assertTrue(result.get("Created"));
	}


	@Test
	public void testUpdatePerson() throws ResourceNotFoundException {
		Person person = new Person();
		person.setFirstName("Srinivas");
		person.setLastName("Duggempudi");
		person.setPersonID(Long.valueOf(101));
		
		Mockito.when(personService.updatePerson(ArgumentMatchers.any(Long.class),ArgumentMatchers.any())).thenReturn(person);
		 ResponseEntity<Person> result = personController.updatePerson(Long.valueOf(101),person);
		assertEquals(result.getBody(), person);
	}
	
	
	@Test
	public void testDeletePerson() throws Exception {
		Map<String, Boolean> deletePerson = personController.deletePerson(Long.valueOf(101));
		assertTrue(deletePerson.get("deleted"));
	}
}
