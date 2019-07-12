package com.forfun.springdata;

import com.forfun.springdata.entity.Person;
import com.forfun.springdata.jdbc.PersonJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataApplication.class, args);
    }

    @Autowired
    PersonJdbcDao personJdbcDao;

    @Override
    public void run(String... args) throws Exception {

        Person anna = new Person(100L, "Anna", "Andreeva", "Samara");
        Person olesya = new Person(101L, "Olesya", "Andreeva", "Moscow");
        Person alex = new Person(102L, "Alex", "Andreev", "Omsk");

        personJdbcDao.insert(anna);
        personJdbcDao.insert(olesya);
        personJdbcDao.insert(alex);

        System.out.println("<<<<<<<<"+personJdbcDao.findAll());
    }
}
