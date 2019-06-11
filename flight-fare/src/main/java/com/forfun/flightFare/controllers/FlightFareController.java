package com.forfun.flightFare.controllers;

import com.forfun.flightFare.dao.FlightFareRepository;
import com.forfun.flightFare.models.CurrencyConversionVO;
import com.forfun.flightFare.models.FlightFare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/flight/{flightCode}/fare/{currency}")
public class FlightFareController {

    @Autowired
    private FlightFareRepository repository;

    @Value("${base.currency:USD}")
    private String baseCurrency;

    @GetMapping
    public FlightFare getSingleTicketFare(@PathVariable String flightCode, @PathVariable String currency) {
        FlightFare fare = getFlightFare(flightCode);
        fare.setCurrency(currency);

        if (!baseCurrency.equals(currency)) {
            //conversion rate
            BigDecimal conversionRate = getConversion(currency);
            BigDecimal convertedFare = fare.getFlightFare().multiply(conversionRate);
            fare.setFlightFare(convertedFare);
        }
        return fare;
    }

    private FlightFare getFlightFare(String flightCode) {
        FlightFare flight = new FlightFare(null, flightCode, null);
        Example<FlightFare> fareFilter = Example.of(flight);
        FlightFare fare = repository.findOne(fareFilter).get();

        return fare;
    }

    private BigDecimal getConversion(String toCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> urlPathVariables = new HashMap();

        urlPathVariables.put("from", baseCurrency);
        urlPathVariables.put("to", toCurrency);

        ResponseEntity<CurrencyConversionVO> responseEntity = restTemplate.getForEntity("http://localhost:7101/api/v1/from/{from}/to/{to}",
                CurrencyConversionVO.class, urlPathVariables);

        CurrencyConversionVO converter = responseEntity.getBody();
        return converter.getConversioRate();
    }


}
