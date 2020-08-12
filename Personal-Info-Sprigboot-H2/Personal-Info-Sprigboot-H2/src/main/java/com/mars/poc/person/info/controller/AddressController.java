package com.mars.poc.person.info.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mars.poc.person.info.domain.Address;
import com.mars.poc.person.info.exception.ResourceNotFoundException;
import com.mars.poc.person.info.service.AddressService;

@RestController
@RequestMapping("/api/v1")
public class AddressController {

	@Autowired
	AddressService addressService;

	@GetMapping("/addresses")
	public List<Address> getAllAddresss() {
		return addressService.getAllAddresss();
	}

	@GetMapping("/address/person/{id}")
	public List<Address> getAddressById(@PathVariable(value = "id") Long presonID , @RequestParam(value = "addressid" , required= false) Long addressID )
			throws ResourceNotFoundException {
		return addressService.getAddressById(presonID , addressID );
	}

	@PostMapping("/address")
	public Address createAddress(@Valid @RequestBody Address Address) {
		return addressService.createAddress(Address);
	}

	@PutMapping("/address/{addrid}/person/{personid}")
	public ResponseEntity<Address> updateAddress(@PathVariable(value = "personid") Long personID , @PathVariable(value = "addrid") Long addrID ,
			@Valid @RequestBody Address address) throws ResourceNotFoundException {
		Address updateAddress = addressService.updateAddress(personID, addrID, address);
		return ResponseEntity.ok(updateAddress);
	}

	@DeleteMapping("/address/{addrid}/person/{personid}")
	public Map<String, Boolean> deleteAddress(@PathVariable(value = "personid") Long personID, @PathVariable(value = "addrid") Long addressID) throws Exception {
		addressService.deleteAddress(personID, addressID);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
