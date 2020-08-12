package com.mars.poc.person.info.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mars.poc.person.info.domain.Address;
import com.mars.poc.person.info.exception.ResourceNotFoundException;
import com.mars.poc.person.info.repository.AddressRepository;
import com.mars.poc.person.info.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepository addressRepository;

	public Address createAddress(Address address) {
		return addressRepository.save(address);		
	}

	public List<Address> getAddressById(Long personID , Long addressID) {
		List<Address> addrs = new ArrayList<>();
		if(addressID == null) {
			addrs.addAll(addressRepository.findByPersonID(personID));
		}else {
			addrs.add(addressRepository.findByPersonIDAndAddressID(personID, addressID));
		}
		return addrs;

	}

	@Override
	public List<Address> getAllAddresss() {
		return addressRepository.findAll();
	}

	@Override
	public Address updateAddress( Long personID ,Long addressID,   Address address) throws ResourceNotFoundException{
		
		Address result = addressRepository.findByPersonIDAndAddressID(personID, addressID);
		if(result == null) {
			throw new ResourceNotFoundException("Record not found for this personID" + personID + "and addressID"+addressID);
		}
		result.setCity(address.getCity());
		result.setStreet(address.getStreet());
		result.setState(address.getState());
		result.setPostalCode(address.getPostalCode());
		addressRepository.save(result);
		return result;
	}

	@Override
	public void deleteAddress(Long personID , Long addressID) {
		Address address = addressRepository.findByPersonIDAndAddressID(personID, addressID);
		addressRepository.delete(address);
	}
	
	@Override
	public void deleteByPersonID(Long personID) {
			addressRepository.deleteByPersonID(personID);
	}

}
