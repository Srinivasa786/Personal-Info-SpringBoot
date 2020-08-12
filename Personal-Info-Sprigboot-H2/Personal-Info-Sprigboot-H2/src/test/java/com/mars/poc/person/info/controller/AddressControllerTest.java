package com.mars.poc.person.info.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

import com.mars.poc.person.info.domain.Address;
import com.mars.poc.person.info.service.AddressService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class AddressControllerTest {

	@InjectMocks
	AddressController addressController;
	
	@Mock
	AddressService addressService;
	
	@Test
	public void testGetAllAddresses()  throws Exception {
		List<Address> addresses = new ArrayList<Address>();
		
		Address address = new Address();
		address.setAddressID(Long.valueOf(101));
		address.setCity("Hyd");
		address.setPersonID(Long.valueOf(101));
		address.setPostalCode("5577886");
		address.setState("TN");
		address.setStreet("LB Nagar");
		addresses.add(address);
		
		Mockito.when(addressService.getAllAddresss()).thenReturn(addresses);
		List<Address> result = addressController.getAllAddresss();

	}
	
	@Test
	public void testgetAddressById()  throws Exception {
		List<Address> addresses = new ArrayList<Address>();
		Address address = new Address();
		address.setAddressID(Long.valueOf(101));
		address.setCity("Hyd");
		address.setPersonID(Long.valueOf(101));
		address.setPostalCode("5577886");
		address.setState("TN");
		address.setStreet("LB Nagar");
		
		Mockito.when(addressService.getAddressById(ArgumentMatchers.any(Long.class),ArgumentMatchers.any(Long.class))).thenReturn(addresses);
		 addressController.getAddressById(Long.valueOf(101), Long.valueOf(101));
	}
	
	
	@Test
	public void testCreateAddress() throws Exception {
		Address address = new Address();
		address.setAddressID(Long.valueOf(101));
		address.setCity("Hyd");
		address.setPersonID(Long.valueOf(101));
		address.setPostalCode("5577886");
		address.setState("TN");
		address.setStreet("LB Nagar");

		Mockito.when(addressService.createAddress(ArgumentMatchers.any())).thenReturn(address);
		Address addr = addressController.createAddress(address);
		assertEquals(Long.valueOf(101), addr.getAddressID());

	}
	
	@Test
	public void testDeleteAddress() throws Exception {
		Map<String, Boolean> result = addressController.deleteAddress(Long.valueOf(101), Long.valueOf(101));
		assertTrue(result.get("deleted"));
	}
	
}
