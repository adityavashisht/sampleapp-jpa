package com.indasil.sampleapp.service;

import com.indasil.sampleapp.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

/**
 * Created by vashishta on 10/17/16.
 */
@Component
@Transactional
public class PersonService {

    @Autowired
    private EntityManager entityManager;


    public Person getById(Long id) {
        return entityManager.find(Person.class, id);
    }


    public Person getByName(String name) {
        Person person = null;
        List<Person> personList = entityManager.createQuery("select p from Person p where p.name=?").setParameter(1, name).getResultList();
        if (personList != null && personList.size() > 0) {
            person = personList.get(0);
        }
        return person;
    }

    /**
     * @param person
     * @return
     */
    public Person save(Person person) {
        person.setDob(new Date());
        entityManager.merge(person);
        return person;
    }

    public List<Person> getAll() {
        return entityManager.createQuery("select p from Person p").getResultList();
    }
}
