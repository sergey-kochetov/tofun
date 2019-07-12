package com.forfun.springdata;

import com.forfun.springdata.entity.Address;
import com.forfun.springdata.entity.Passport;
import com.forfun.springdata.entity.Person;
import com.forfun.springdata.entity.Phone;
import com.forfun.springdata.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringdataJPAApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringdataJPAApplication.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

        Person anna = new Person("Anna", "Andreeva");
        Person olesya = new Person("Olesya", "Andreeva");
        Person alex = new Person("Alex", "Andreev");

        Passport passport1 = new Passport("SK-123123");
        Passport passport2 = new Passport("SK-567567");
        Passport passport3 = new Passport("SK-645645");

        Phone phone1 = new Phone("Apple-2");
        Phone phone2 = new Phone("Apple-3");
        Phone phone3 = new Phone("Apple-6");
        Phone phone4 = new Phone("Apple-10");

        Address address1 = new Address("Moscow");
        Address address2 = new Address("Kiev");
        Address address3 = new Address("Minsk");
        Address address4 = new Address("Berlin");

        anna.setPassport(passport1);
        anna.setPhones(Arrays.asList(phone1, phone2));
        anna.setAddresses(Arrays.asList(address1, address2));
        olesya.setPassport(passport2);
        olesya.setAddresses(Arrays.asList(address3));
        olesya.setPhones(Arrays.asList(phone3));
        alex.setPassport(passport3);
        alex.setPhones(Arrays.asList(phone3, phone4));
        alex.setAddresses(Arrays.asList(address4));

        List<Person> people = Arrays.asList(anna, olesya, alex);

        personRepository.saveAll(people);
    }
}