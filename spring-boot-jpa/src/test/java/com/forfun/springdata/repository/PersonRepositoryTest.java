package com.forfun.springdata.repository;

import com.forfun.springdata.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest {
    @Autowired
    PersonRepository personRepository;

    @Test
    public void findByFirstName() {
        List<Person> anna = personRepository.findByFirstName("Anna");

        assertEquals("Anna", anna.get(0).getFirstName());
        assertEquals("Andreeva", anna.get(0).getLastName());
        assertEquals("Samara", anna.get(0).getAddress());
    }


    @Test
    public void findAllOrderedByFirstName() {
        List<Person> people = personRepository.findAllOrderedByFirstName();

        assertEquals(3, people.size());
        assertEquals("Alex", people.get(0).getFirstName());
        assertEquals("Anna", people.get(1).getFirstName());
        assertEquals("Olesya", people.get(2).getFirstName());
    }
}