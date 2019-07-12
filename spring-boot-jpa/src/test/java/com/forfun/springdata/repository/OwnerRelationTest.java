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
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OwnerRelationTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void inverseEndTest() {
        List<Person> people = personRepository.findByFirstName("Anna");
        Person anna = people.get(0);

        anna.setLastName("NewLastName");
        anna.setAddresses(Arrays.asList(new Address("Moscow")));

        personRepository.save(anna);
    }

    @Test
    public void ownerTest() {
        List<Address> city = addressRepository.findByCity("Moscow");
        Address address = city.get(0);

        address.setHouseNumber("432");
        address.setPerson(new Person("Sergey", "Sergeich"));

        addressRepository.save(address);
    }
}
