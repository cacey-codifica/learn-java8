package com.codifica.java8.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.codifica.java8.entity.Person;
import com.codifica.java8.repository.PersonRepository;
import com.codifica.java8.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private final PersonRepository personRepository;
	
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<Person> getPersonsByAdType(String adType) {
		List<Person> audience = personRepository.findAll();
		
		if(CollectionUtils.isEmpty(audience)) return null;
		
		switch (adType) {
			case "protein-shake": 
				audience = Person.filterPersons(audience, Person::isPersonAnAdult);
				break;
			case "acv": 
				audience = Person.filterPersons(audience, Person::isPersonOverweight);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + adType);
		}
		
		return audience;
	}
}
