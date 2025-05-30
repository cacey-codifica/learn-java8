package com.codifica.java8.service;

import java.util.List;

import com.codifica.java8.entity.Person;

public interface PersonService {
	List<Person> getPersonsByAdType(String adType);
}
