package com.codifica.java8.FunctionalInterface;

@FunctionalInterface
public interface FilterPerson<T>{
	boolean filter(T t);
}
