package com.mars.poc.person.info.service;

import java.util.List;

import com.mars.poc.person.info.domain.Person;
import com.mars.poc.person.info.exception.ResourceNotFoundException;

public interface PersonService {
	public Person createPerson(Person person);
	public Person getPersonById(Long id) throws ResourceNotFoundException;
	public List<Person> getAllPersons();
	public Person updatePerson(Long personID, Person person) throws ResourceNotFoundException;
	public void deletePerson(Long personID);
}
