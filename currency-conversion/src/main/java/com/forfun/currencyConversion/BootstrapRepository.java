package com.forfun.currencyConversion;

import com.forfun.currencyConversion.dao.CurrencyConversionRepository;
import com.forfun.currencyConversion.models.CurrencyConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BootstrapRepository implements CommandLineRunner {

    @Autowired
    private CurrencyConversionRepository repository;

    @Override
    public void run(String... args) throws Exception {
        CurrencyConverter converter1 = new CurrencyConverter(1L, "USD", "RUB", BigDecimal.valueOf(65.04));
        CurrencyConverter converter2 = new CurrencyConverter(2L, "USD", "UAH", BigDecimal.valueOf(25.14));

        repository.save(converter1);
        repository.save(converter2);
    }
}
