package com.example.hibernate.dataaccess;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.example.hibernate.model.Person;

@Repository
//@ImportResource("classpath:applicationContext.hibernate.xml")
public class PersonDaoImpl implements PersonDao {
	@Autowired
    private SessionFactory sessionFactory;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@SuppressWarnings("deprecation")
    public List<Person> findPerson() {
    	Session session = sessionFactory.getCurrentSession();
    	Query query = session.createQuery("from Person");
        return query.list();
    }
    public void addPerson(Person person) {
    	Session session = sessionFactory.getCurrentSession();
    	session.save(person);
    	session.flush();
//        hibernateTemplate.save(person);
//        hibernateTemplate.flush();
    }
    public void removePerson (Person person) {
    	Session session = sessionFactory.getCurrentSession();
    	session.delete(person);
    	session.flush();

//        hibernateTemplate.delete(person);
//        hibernateTemplate.flush();
    }
    public void updatePerson(Person person) {
    	Session session = sessionFactory.getCurrentSession();
    	session.update(person);
    	session.flush();

//        hibernateTemplate.update(person);
//        hibernateTemplate.flush();
    }


}