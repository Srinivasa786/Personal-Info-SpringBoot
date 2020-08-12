package com.mars.poc.person.info.domain;

import java.io.Serializable;

public class AddressPK implements Serializable{

	private static final long serialVersionUID = -7728127047745743155L;

	private Long personID;
	
	private Long addressID;
	

	public AddressPK() {
	}

	public AddressPK(Long personID, Long addressID) {
		this.personID = personID;
		this.addressID = addressID;
	}

	public Long getPersonID() {
		return personID;
	}

	public void setPersonID(Long personID) {
		this.personID = personID;
	}

	public Long getAddressID() {
		return addressID;
	}

	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressID == null) ? 0 : addressID.hashCode());
		result = prime * result + ((personID == null) ? 0 : personID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressPK other = (AddressPK) obj;
		if (addressID == null) {
			if (other.addressID != null)
				return false;
		} else if (!addressID.equals(other.addressID))
			return false;
		if (personID == null) {
			if (other.personID != null)
				return false;
		} else if (!personID.equals(other.personID))
			return false;
		return true;
	}

	
	
}
