package com.igor.calculator.services;

import org.springframework.stereotype.Service;

@Service
public class Calculator {
    public int sumInegerNumbers(final int a, final int b) {
        return a + b;
    }
}
