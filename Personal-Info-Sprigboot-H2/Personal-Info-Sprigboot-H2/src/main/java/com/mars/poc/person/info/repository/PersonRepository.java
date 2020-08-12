package com.mars.poc.person.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mars.poc.person.info.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}