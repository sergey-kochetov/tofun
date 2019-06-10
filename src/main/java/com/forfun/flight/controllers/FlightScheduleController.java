package com.forfun.flight.controllers;

import com.forfun.flight.models.Flight;
import com.forfun.flight.services.FlightScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/flights")
public class FlightScheduleController {

    @Resource(name = "flightScheduleService")
    private FlightScheduleService flightScheduleService;

    @GetMapping(value = "/from/{from}/to/{to}")
    public List<Flight> getFlights(@PathVariable String from, @PathVariable String to) {
        List<Flight> flights = flightScheduleService.getFlights(from, to);

        return flights;
    }
}
