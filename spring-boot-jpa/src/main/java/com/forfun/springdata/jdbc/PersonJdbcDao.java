package com.forfun.springdata.jdbc;

import com.forfun.springdata.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        List<Person> people = jdbcTemplate.query("select * from jpa.person",
                new BeanPropertyRowMapper<>(Person.class));

        return people;
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into jpa.person " +
                        "(id, first_name, last_name, address) " +
                        "values (?,?,?,?)",
                new Object[]{
                        person.getId(), person.getFirstName(),
                        person.getLastName(), person.getAddress()
                });
    }
}