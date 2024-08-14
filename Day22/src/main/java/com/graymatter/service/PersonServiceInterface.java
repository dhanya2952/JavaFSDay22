package com.graymatter.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.graymatter.entities.Person;

public interface PersonServiceInterface {
	
	public ResponseEntity<?> getAllPersons();
	public ResponseEntity<?> addPerson(Person p);
	public ResponseEntity<?> updatePerson(Person p);
	public ResponseEntity<?> findPersonById(Long pid);
	public void deletePerson(long pid);

}
