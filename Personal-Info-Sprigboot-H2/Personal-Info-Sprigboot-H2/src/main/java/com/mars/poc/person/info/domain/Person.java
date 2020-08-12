package com.mars.poc.person.info.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PERSON_ID")
	private Long personID;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@OneToMany(fetch=javax.persistence.FetchType.LAZY, cascade={javax.persistence.CascadeType.ALL} ,orphanRemoval=true)
	@JoinColumn(name="PERSON_ID" ,updatable = false)
	private Set<Address> addresses;

	public Set<Address> getAddresses() {
		return Collections.unmodifiableSet(_getAddresses());
	}

	public Person addAddress(Address address) {
		_getAddresses().add(address);
		address.setPersonID(this.personID);
		return this;
	}

	public Set<Address> _getAddresses() { 
		if (addresses == null) {
			addresses = new HashSet<>();
		}
		return addresses;
	}

	public void deleteAllAddresses() {
		this._getAddresses().clear();  
	}

	public Long getPersonID() {
		return personID;
	}

	public void setPersonID(Long personID) {
		this.personID = personID;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
