package com.forfun.flight.services;

import com.forfun.flight.dao.FlightScheduleRepository;
import com.forfun.flight.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service("flightScheduleService")
public class FlightScheduleServiceImpl implements FlightScheduleService {

    @Value("${airline.disable}")
    private String airlineDisabled;

    @Autowired
    private FlightScheduleRepository flightRepository;

    @Override
    public List<Flight> getFlights(String from, String to) {
        Flight filterFlight = new Flight();
        filterFlight.setFlightFrom(from);
        filterFlight.setFlightTo(to);

        Example<Flight> flightExample = Example.of(filterFlight);
        List<Flight> flightList = flightRepository.findAll(flightExample);
        if (!CollectionUtils.isEmpty(flightList)) {
            flightList = flightList.stream()
                    .filter(flight -> !airlineDisabled.equals(flight.getAirline()))
                    .collect(Collectors.toList());
        }
        return flightList;
    }
}
