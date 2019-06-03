package com.example.hibernate.dataaccess;


import java.util.List;

import com.example.hibernate.model.Person;

public interface PersonDao {
    List<Person> findPerson();
    void addPerson(Person person);
    void removePerson(Person person);
    void updatePerson(Person person);
}