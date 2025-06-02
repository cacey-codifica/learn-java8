package com.codifica.java8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codifica.java8.entity.Person;
import com.codifica.java8.service.PersonService;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {
	
	@Autowired 
	private PersonService personService;
	
	@GetMapping("/ad-audience")
	public ResponseEntity<List<Person>> getTargetedAudienceForAd(@RequestParam("adType") String adType){
		List<Person> audience = personService.getPersonsByAdType(adType);
		HttpStatus responseStatus = (audience == null) ? HttpStatus.NO_CONTENT : HttpStatus.OK ;
		return new ResponseEntity<List<Person>>(audience, responseStatus);
	}
}
