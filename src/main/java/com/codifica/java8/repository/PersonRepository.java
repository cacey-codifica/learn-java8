package com.codifica.java8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codifica.java8.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query(value = "select person from Person person where person.email = :emailId")
	public List<Person> getPersonsByEmailId(String emailId);
}
