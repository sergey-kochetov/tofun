package com.forfun.flight.services;

import com.forfun.flight.models.Flight;

import java.util.List;

public interface FlightScheduleService {
    List<Flight> getFlights(String from, String to);
}
