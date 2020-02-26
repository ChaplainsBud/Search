package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PersonRepository extends CrudRepository<Person, Long> {

    public ArrayList<Person> findByName(String name);
}
