package com.mars.poc.person.info.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.poc.person.info.domain.Address;
import com.mars.poc.person.info.domain.Person;
import com.mars.poc.person.info.exception.ResourceNotFoundException;
import com.mars.poc.person.info.repository.AddressRepository;
import com.mars.poc.person.info.repository.PersonRepository;
import com.mars.poc.person.info.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AddressRepository addressRepository;

	public Person createPerson(Person person) {
		
		Set<Address> addresses = new HashSet<>();
		
		Set<Address> addrs = person.getAddresses();
		addrs.forEach(addr-> addresses.add(addr));
		
		person.deleteAllAddresses();
		personRepository.save(person);
		
		addresses.forEach(addr ->{
			addr.setPersonID(person.getPersonID());
			addressRepository.save(addr);

		});
		 return person;
	}

	public Person getPersonById(Long id) throws ResourceNotFoundException {
		return personRepository.findById(id)
		        .orElseThrow(() -> new ResourceNotFoundException("Person not found on :: "+ id));

	}

	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person updatePerson(Long personID, Person person) throws ResourceNotFoundException {

		Person result = personRepository.findById(personID)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found on :: " + personID));
		result.setLastName(person.getLastName());
		result.setFirstName(person.getFirstName());
		personRepository.save(result);
		return result;
	}

	@Override
	public void deletePerson(Long personID) {
		personRepository.deleteById(personID);
		
	}
	 

}
