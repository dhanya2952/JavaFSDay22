package com.graymatter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.graymatter.dao.PersonDao;
import com.graymatter.entities.Person;

@Service
public class PersonServiceImpl implements PersonServiceInterface{

	@Autowired
	PersonDao dao;
	@Override
	public ResponseEntity<?> getAllPersons() {
		// TODO Auto-generated method stub
		return dao.getAllPersons();
	}
	
	@Override
	public ResponseEntity<?> addPerson(Person p) {
		// TODO Auto-generated method stub
		return dao.addPerson(p);
	}

	@Override
	public ResponseEntity<?> updatePerson(Person p) {
			// TODO Auto-generated method stub
		return dao.updatePerson(p);
	}

	
	@Override
	public ResponseEntity<?> findPersonById(Long pid) {
		// TODO Auto-generated method stub
		return dao.findPersonById(pid);
	}

	@Override
	public void deletePerson(long pid) {
		// TODO Auto-generated method stub
		 dao.deletePerson(pid);
	}

}
