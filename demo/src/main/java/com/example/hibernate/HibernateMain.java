package com.example.hibernate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.hibernate.model.Person;
import com.example.hibernate.service.PersonService;

public class HibernateMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.hibernate.xml");
        PersonService personService = ctx.getBean(PersonService.class);

        Person person = new Person();
        person.setId("person003");
        person.setName("testname");

        personService.addPerson(person);

        List<Person> list = personService.findPerson();
        System.out.println(list.get(0).getName());

        person.setName("foo");

        System.out.println(person.getName());

//        Person person2 = new Person();
//        person.setId("person003");
//        person.setName("foo");
//        personService.addPerson(person2);
        personService.updatePerson(person);//何故かデフォルトではread-only="true":addには記述なし
        									//applicationContext.xmlを優先して読み込んでしまっている？
        									//アップデートされない(エラーはなし)

        personService.removePerson(person);
    }
}
