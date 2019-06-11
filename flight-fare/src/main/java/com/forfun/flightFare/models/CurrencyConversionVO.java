package com.forfun.flightFare.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyConversionVO {

    private String currencyFrom;
    private String currencyTo;
    private BigDecimal conversioRate;

    public CurrencyConversionVO() {
    }

}
