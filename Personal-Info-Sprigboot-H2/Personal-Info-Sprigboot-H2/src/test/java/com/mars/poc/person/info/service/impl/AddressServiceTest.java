package com.mars.poc.person.info.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mars.poc.person.info.domain.Address;
import com.mars.poc.person.info.repository.AddressRepository;
import com.mars.poc.person.info.service.AddressService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class AddressServiceTest {

	@InjectMocks
	AddressService addressService;

	@Mock
	AddressRepository addressRepository;

	@Test
	public void testCreateAddress() {

		Address address = new Address();
		address.setAddressID(Long.valueOf(101));
		address.setCity("Hyd");
		address.setPersonID(Long.valueOf(101));
		address.setPostalCode("5577886");
		address.setState("TN");
		address.setStreet("LB Nagar");

		Mockito.when(addressRepository.save(ArgumentMatchers.any())).thenReturn(address);
		Address addr = addressService.createAddress(address);
		assertEquals(Long.valueOf(101), addr.getAddressID());
	}
	
	@Test
	public void testGetAllAddresss() throws Exception {
		List<Address> addresses = new ArrayList<Address>();
		Address address = new Address();
		address.setAddressID(Long.valueOf(101));
		address.setCity("Hyd");
		address.setPersonID(Long.valueOf(101));
		address.setPostalCode("5577886");
		address.setState("TN");
		address.setStreet("LB Nagar");

		Mockito.when(addressRepository.findAll()).thenReturn(addresses);
		List<Address> result = addressService.getAllAddresss();
		assertNotNull(result);
	}
	
	@Test
	public void testUpdateAddress() throws Exception {
		Address address = new Address();
		address.setAddressID(Long.valueOf(101));
		address.setCity("Hyd");
		address.setPersonID(Long.valueOf(101));
		address.setPostalCode("5577886");
		address.setState("TN");
		address.setStreet("LB Nagar");

		Mockito.when(addressRepository.findByPersonIDAndAddressID(ArgumentMatchers.any(Long.class),
				ArgumentMatchers.any(Long.class))).thenReturn(address);
		Address result = addressService.updateAddress(Long.valueOf(101), Long.valueOf(101), address);
		assertNotNull(result);

	}

}
