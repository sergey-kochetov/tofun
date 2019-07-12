package com.forfun.springdata.repository;

import com.forfun.springdata.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByFirstName(String firstName);

    @Query("select p from Person p order by firstName")
    List<Person> findAllOrderedByFirstName();
}