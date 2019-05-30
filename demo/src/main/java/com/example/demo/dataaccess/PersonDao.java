package com.example.demo.dataaccess;


import java.util.List;

import com.example.demo.model.Person;

public interface PersonDao {
    List<Person> findPerson();
    void addPerson(Person person);
    void removePerson(Person person);
    void updatePerson(Person person);
}