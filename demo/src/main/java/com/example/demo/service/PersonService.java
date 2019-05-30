package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Person;

//@ImportResource("classpath:applicationContext.hibernate.xml")
public interface PersonService {

	List<Person> findPerson();
    void addPerson(Person person);
    void updatePerson(Person person);
    void removePerson(Person person);
}
