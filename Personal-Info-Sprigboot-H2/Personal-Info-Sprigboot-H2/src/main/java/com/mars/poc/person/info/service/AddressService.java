package com.mars.poc.person.info.service;

import java.util.List;

import com.mars.poc.person.info.domain.Address;
import com.mars.poc.person.info.exception.ResourceNotFoundException;

public interface AddressService {
	public Address createAddress(Address address);
	public List<Address> getAddressById(Long id , Long adrssId);
	public List<Address> getAllAddresss();
	public Address updateAddress(Long personId , Long addressID, Address address) throws ResourceNotFoundException;
	public void deleteAddress(Long personID, Long addressID);
	void deleteByPersonID(Long personID);
}
