package com.forfun.currencyConversion.dao;

import com.forfun.currencyConversion.models.CurrencyConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConverter, Long> {
}
