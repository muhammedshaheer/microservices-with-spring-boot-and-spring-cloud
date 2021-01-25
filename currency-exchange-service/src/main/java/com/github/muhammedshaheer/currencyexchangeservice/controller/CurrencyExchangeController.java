package com.github.muhammedshaheer.currencyexchangeservice.controller;

import com.github.muhammedshaheer.currencyexchangeservice.dto.CurrencyExchange;
import com.github.muhammedshaheer.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Muhammed Shaheer
 * @since 18 January 2021
 */

@RestController
public class CurrencyExchangeController {
    public static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    private final CurrencyExchangeRepository currencyExchangeRepository;
    private final Environment environment;

    public CurrencyExchangeController(CurrencyExchangeRepository currencyExchangeRepository, Environment environment) {
        this.currencyExchangeRepository = currencyExchangeRepository;
        this.environment = environment;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable("from") String from,
            @PathVariable("to") String to
    ) {
        logger.info("retrieveExchangeValue called with {} to {}", from, to);
        Optional<CurrencyExchange> currencyExchangeOptional = currencyExchangeRepository.findByFromAndTo(from, to);
        String port = "local.server.port";
        if (currencyExchangeOptional.isPresent()) {
            CurrencyExchange currencyExchange = currencyExchangeOptional.get();
            currencyExchange.setEnvironment(environment.getProperty(port));
            return currencyExchange;
        } else {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }
    }
}
