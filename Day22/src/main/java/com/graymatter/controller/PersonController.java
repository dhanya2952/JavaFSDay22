package com.graymatter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graymatter.entities.Person;
import com.graymatter.service.PersonServiceImpl;

@RestController //controller+responseBody
@RequestMapping("/api/v1")
public class PersonController {
	
	@Autowired
	PersonServiceImpl service;
	
	@GetMapping("/person")
	public ResponseEntity<?> getAllPersons()
	{
		return service.getAllPersons();
	}
	
	@PostMapping("/person")
	public ResponseEntity<?> addPerson(@RequestBody Person p)
	{
		return service.addPerson(p);
	}
	
	@PutMapping("/person/{id}")
	public ResponseEntity<?> updatePerson(@RequestBody Person p,@PathVariable("id") long pid)
	{
		return service.updatePerson(p);
	}
	
	@GetMapping("/person/{id}")
	public ResponseEntity<?> findPersonById(@PathVariable("id") long pid)
	{
		return service.findPersonById(pid);
	}
	
	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable("id") long pid)
	{
		 service.deletePerson(pid);
	}

}
