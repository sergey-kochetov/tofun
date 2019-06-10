package com.forfun.flight;

import com.forfun.flight.dao.FlightScheduleRepository;
import com.forfun.flight.models.Flight;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapRepository implements CommandLineRunner {

    private final FlightScheduleRepository flightRepository;

    public BootStrapRepository(FlightScheduleRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Flight flight1 = new Flight(1L, "UL-191", "MOS", "KYV", "Moscow Airlines", "01:40", "05:30");
        Flight flight2 = new Flight(2L, "UL-192", "MOS", "KYV", "Kirov Airlines", "01:45", "05:35");
        Flight flight3 = new Flight(3L, "UL-193", "MOS", "KYV", "Kiev Airlines", "01:55", "06:35");
        Flight flight4 = new Flight(4L, "UL-194", "MOS", "KYV", "Kiev Airlines", "03:55", "09:35");
        Flight flight5 = new Flight(5L, "UL-195", "MOS", "KYV", "Moscow2 Airlines", "04:05", "10:30");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        flightRepository.save(flight4);
        flightRepository.save(flight5);
    }
}
