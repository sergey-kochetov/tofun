package com.forfun.flight.dao;

import com.forfun.flight.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightScheduleRepository extends JpaRepository<Flight, Long> {
}
