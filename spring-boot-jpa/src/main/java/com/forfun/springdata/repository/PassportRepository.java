package com.forfun.springdata.repository;

import com.forfun.springdata.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {
    Passport findByNumber(String number);
}
