package com.github.muhammedshaheer.limitsservice.controller;

import com.github.muhammedshaheer.limitsservice.configuration.Configuration;
import com.github.muhammedshaheer.limitsservice.entity.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Muhammed Shaheer
 * @since 18 January 2021
 */

@RestController
public class LimitsController {

    private final Configuration configuration;

    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits retrieveLimits() {
//        return new Limits(1, 1000);
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
