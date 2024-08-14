package com.graymatter.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.graymatter.entities.Person;
import com.graymatter.repositories.PersonRepository;

@Repository
public class PersonDao {
	
	@Autowired
	PersonRepository repository;
	
	public ResponseEntity<?> getAllPersons()
	{
		List<Person> plist=repository.findAll();
		Map<String, Object> map= new HashMap<String, Object>();
		
		if(!(plist.isEmpty()))
		{
			map.put("status", 10);
			map.put("data", plist);
			return new ResponseEntity<>(map,HttpStatus.OK);
		}
		else
		{
			map.put("status", 20);
			map.put("data", "list is empty");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
			
		}
		
	}
	
	public ResponseEntity<?> addPerson(Person p)
	{
		Map<String, Object> map= new HashMap<String, Object>();
		Person person=repository.save(p);
		if(p!=null)
		{
			map.put("status",11);
			map.put("data", person);
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		}
		else
		{
			map.put("status",12);
			map.put("data", "person not added");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
		
	}

	public ResponseEntity<?> updatePerson(Person p) {
		// TODO Auto-generated method stub
		Map<String, Object> map= new HashMap<String, Object>();
		Person person=repository.findById(p.getAadharNum()).get();
		
		if(person!=null)
		{
		person.setName(p.getName());
		person.setMobile(p.getMobile());
		person.setAge(p.getAge());
		person.setEmail(p.getEmail());
		
		map.put("status",13);
		map.put("data", repository.save(person));
		return new ResponseEntity<>(map,HttpStatus.CREATED);
		 
		}
		else
		{
			map.put("status",14);
			map.put("data", "person not found");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<?> findPersonById(long pid) {
		// TODO Auto-generated method stub
		Map<String, Object> map= new HashMap<String, Object>();
		Person p= repository.findById(pid).get();
		if(p!=null)
		{
			map.put("status",15);
			map.put("data", p);
			return new ResponseEntity<>(map,HttpStatus.FOUND);
		}
		else
		{
			map.put("status",16);
			map.put("data", "person not found for the id");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
		
	}

	public void deletePerson(long pid) {
		// TODO Auto-generated method stub
		repository.deleteById(pid);
	}

}
