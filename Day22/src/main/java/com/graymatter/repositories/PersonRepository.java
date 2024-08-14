package com.graymatter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graymatter.entities.Person;

	
public interface PersonRepository extends JpaRepository<Person, Long>{

}
