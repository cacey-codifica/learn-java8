package com.codifica.java8.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product", schema = "codifica_java8")
public class Product {
	@Id
	private int id;
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("price")
    private double price;
	
	@JsonProperty("category")
    private String category;
}
