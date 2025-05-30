package com.codifica.java8.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.util.CollectionUtils;

import com.codifica.java8.FunctionalInterface.FilterPerson;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
@Entity
@Table(name = "person", schema = "codifica_java8")
public class Person {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long personId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("weight")
	private float weight;
	
	@JsonProperty("height")
	private float height;
	
	@JsonProperty("dateOfBirth")
	private Date dateOfBirth;
	
	@JsonIgnore
	public boolean isPersonAnAdult() {
		return true;
	}
	
	@JsonIgnore
	public boolean isPersonOverweight() {
		return false;
	}
	
	public static List<Person> filterPersons(List<Person> persons, Predicate<Person> filterCriteria){
		List<Person> eligiblePersons = new ArrayList<Person>();
		for (Person person : persons) {
			if(filterCriteria.test(person)) {
				eligiblePersons.add(person);
			}
		}
		
		return eligiblePersons;
	}
}
