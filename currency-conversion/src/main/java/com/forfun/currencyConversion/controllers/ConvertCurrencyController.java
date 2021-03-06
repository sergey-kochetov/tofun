package com.forfun.currencyConversion.controllers;

import com.forfun.currencyConversion.dao.CurrencyConversionRepository;
import com.forfun.currencyConversion.models.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ConvertCurrencyController {

    @Autowired
    private CurrencyConversionRepository repository;

    @GetMapping(value = "/from/{from}/to/{to}")
    public CurrencyConverter currencyConverter(@PathVariable String from, @PathVariable String to) {
        CurrencyConverter converter = new CurrencyConverter(null,from, to, null);
        Example<CurrencyConverter> conversionFilter = Example.of(converter);
        return repository.findOne(conversionFilter).get();
    }
}
