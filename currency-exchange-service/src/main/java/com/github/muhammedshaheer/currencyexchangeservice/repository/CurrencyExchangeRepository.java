package com.github.muhammedshaheer.currencyexchangeservice.repository;

import com.github.muhammedshaheer.currencyexchangeservice.dto.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Muhammed Shaheer
 * @since 18 January 2021
 */

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    Optional<CurrencyExchange> findByFromAndTo(String from, String to);
}
