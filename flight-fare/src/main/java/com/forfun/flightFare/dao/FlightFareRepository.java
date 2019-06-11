package com.forfun.flightFare.dao;

import com.forfun.flightFare.models.FlightFare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightFareRepository extends JpaRepository<FlightFare, Long> {
}
