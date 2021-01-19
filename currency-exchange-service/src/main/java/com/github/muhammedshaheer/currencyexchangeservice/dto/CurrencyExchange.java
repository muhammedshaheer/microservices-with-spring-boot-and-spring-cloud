package com.github.muhammedshaheer.currencyexchangeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author Muhammed Shaheer
 * @since 18 January 2021
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CurrencyExchange {

    @Id
    private Long id;

    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}
