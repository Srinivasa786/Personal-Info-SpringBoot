package com.mars.poc.person.info.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mars.poc.person.info.domain.Address;
import com.mars.poc.person.info.domain.Person;
import com.mars.poc.person.info.exception.ResourceNotFoundException;
import com.mars.poc.person.info.service.AddressService;
import com.mars.poc.person.info.service.PersonService;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@Autowired
	AddressService addressService;

	@GetMapping("/persons")
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}

	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personID)
			throws ResourceNotFoundException {
		Person user = personService.getPersonById(personID);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/person")
	public Map<String, Boolean>  createPerson(@Valid @RequestBody Person person) {
		
        Set<Address> addresses = new HashSet<>();
		
		Set<Address> addrs = person.getAddresses();
		addrs.forEach(addr-> addresses.add(addr));
		person.deleteAllAddresses();
		Person result = personService.createPerson(person);
		
		for(Address addr: addresses) {
			addr.setPersonID(result.getPersonID());
			addressService.createAddress(addr);
		}
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Created", Boolean.TRUE);
		
		return response;
	}

	@PutMapping("/person/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personID,
			@Valid @RequestBody Person person) throws ResourceNotFoundException {
		Person updatePerson = personService.updatePerson(personID, person);
		return ResponseEntity.ok(updatePerson);
	}

	@DeleteMapping("/person/{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personID) throws Exception {
		personService.deletePerson(personID);
		addressService.deleteByPersonID(personID);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
