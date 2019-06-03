package com.example.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernate.dataaccess.PersonDao;
import com.example.hibernate.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;
    public List<Person> findPerson() {
        return personDao.findPerson();
    }
    public void addPerson(Person person) {
        personDao.addPerson(person);
    }
    public void removePerson(Person person) {
        personDao.removePerson(person);
    }
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }


}
