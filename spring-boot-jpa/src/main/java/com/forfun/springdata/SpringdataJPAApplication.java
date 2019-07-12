package com.forfun.springdata;

import com.forfun.springdata.entity.Person;
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
//
//        Person anna = new Person("Anna", "Andreeva", "Samara");
//        Person olesya = new Person("Olesya", "Andreeva", "Moscow");
//        Person alex = new Person("Alex", "Andreev", "Omsk");
//
//        List<Person> people = Arrays.asList(anna, olesya, alex);
//
//        personRepository.saveAll(people);
//
//        System.out.println("<<<<<<<<" + personRepository.findAll());
    }
}