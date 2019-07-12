package com.forfun.springdata.repository;

import com.forfun.springdata.entity.Address;
import com.forfun.springdata.entity.Person;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test(expected = LazyInitializationException.class)
    public void lazyLoading_ThrowException() {
        List<Person> anna = personRepository.findByFirstName("Anna");

        assertEquals("Anna", anna.get(0).getPhones());

    }

    @Test
    @Transactional
    public void lazyLoading_Transactional() {
        List<Person> anna = personRepository.findByFirstName("Anna");

        assertEquals("[Phone[id=3, number='Apple-2'], " +
                "Phone[id=4, number='Apple-3']]", anna.get(0).getPhones().toString());

    }

    @Test
    public void deleteAddress() {
        List<Address> cities = addressRepository.findByCity("Kiev");

        assertEquals(1, cities.size());

        addressRepository.delete(cities.get(0));

        List<Person> people = personRepository.findAll();

        assertEquals(3, people.size());
    }

    @Test
    public void deletePerson() {
        List<Person> people = personRepository.findByFirstName("Alex");

        personRepository.delete(people.get(0));

        List<Address> addresses = addressRepository.findAll();

        assertEquals(3, addresses.size());
    }

    @Test
    public void fetchTypeLoading() {
        List<Person> people = personRepository.findAll();


    }
}
