package com.mars.poc.person.info.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mars.poc.person.info.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	Address findByPersonIDAndAddressID(Long personID , Long addressID);
	List<Address> findByPersonID(Long personID);
	void deleteByPersonIDAndAddressID(Long personID , Long addressID);
	void deleteByPersonID(Long personID);
}