package com.forfun.flight.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightCode;
    private String flightFrom;
    private String flightTo;
    private String airline;
    private String departureTime;
    private String arrivalTime;

    public Flight() {
    }

    public Flight(Long id, String flightCode, String flightFrom, String flightTo, String airline, String departureTime, String arrivalTime) {
        this.id = id;
        this.flightCode = flightCode;
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.airline = airline;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }
}
