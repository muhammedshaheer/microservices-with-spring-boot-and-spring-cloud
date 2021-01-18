package com.github.muhammedshaheer.limitsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Muhammed Shaheer
 * @since 18 January 2021
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Limits {
    private int minimum;
    private int maximum;
}
