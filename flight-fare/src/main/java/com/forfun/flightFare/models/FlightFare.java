package com.forfun.flightFare.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class FlightFare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightCode;
    private BigDecimal flightFare;
    private String currency;

    public FlightFare() {
    }

    public FlightFare(Long id, String flightCode, BigDecimal flightFare) {
        this.id = id;
        this.flightCode = flightCode;
        this.flightFare = flightFare;
    }
}
